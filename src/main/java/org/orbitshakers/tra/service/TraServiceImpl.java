package org.orbitshakers.tra.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.orbitshakers.tra.domain.Domain;
import org.orbitshakers.tra.domain.Question;
import org.orbitshakers.tra.domain.Questionnaire;
import org.orbitshakers.tra.domain.TraAnswer;
import org.orbitshakers.tra.domain.TraOption;
import org.orbitshakers.tra.domain.TraSession;
import org.orbitshakers.tra.entity.ConceptEntity;
import org.orbitshakers.tra.entity.DomainEntity;
import org.orbitshakers.tra.entity.QuestionEntity;
import org.orbitshakers.tra.entity.TraSessionEntity;
import org.orbitshakers.tra.repo.ConceptRepo;
import org.orbitshakers.tra.repo.DomainRepo;
import org.orbitshakers.tra.repo.QuestionRepo;
import org.orbitshakers.tra.repo.TraSessionRepo;
import org.orbitshakers.tra.transformer.DomainTrans;
import org.orbitshakers.tra.transformer.QuestionTrans;
import org.orbitshakers.tra.transformer.TraSessionTrans;
import org.orbitshakers.tra.transformer.Transformer;
import org.orbitshakers.tra.util.RandomGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TraServiceImpl implements TraService{

	private Transformer<DomainEntity, Domain> domainTransformer = new DomainTrans();
	private Transformer<QuestionEntity, Question> questionTransformer = new QuestionTrans();
	private Transformer<TraSessionEntity, TraSession> traSessionTransformer = new TraSessionTrans();
	
	private final DomainRepo repo;
	private final ConceptRepo conceptRepo;
	private final QuestionRepo questionRepo;
	private final TraSessionRepo traSessionRepo;

	@Value( "${session.id.length:20}" )
	private  Integer sessionIdLength;
	
	@Value( "${feedback.probabilityPossibleOutcomes:5}" )
	private Integer feedbackProbabilityPossibleOutcomes;
	
	@Value( "${session.timeout:30}" )
	private Integer sessionTimeout;

	
	public TraServiceImpl(DomainRepo repo, ConceptRepo conceptRepo, QuestionRepo questionRepo, TraSessionRepo traSessionRepo) {

		this.repo = repo;
		this.conceptRepo = conceptRepo;
		this.questionRepo = questionRepo;
		this.traSessionRepo = traSessionRepo;
		
	}

	public Questionnaire getQuestionnaire() {
		Questionnaire questionnaire = new Questionnaire();


		questionnaire.setStandaloneQuestions(this.findAllStandaloneQuestions());
		questionnaire.setDomains(this.findAllDomains());
		questionnaire.setFeedbackQuestions(this.findAllFeedbackQuestions());
		
		return questionnaire;
	}
	
	public List<Question> findAllStandaloneQuestions() {
		List<QuestionEntity> entityList = questionRepo.findAllByQuestionTypeId(new Long(1));

		return entityList.stream().map(questionTransformer::transform)
				.collect(Collectors.toList());

	}
	
	public List<Question> findAllFeedbackQuestions() {
		List<QuestionEntity> entityList = questionRepo.findAllByQuestionTypeId(new Long(3));

		return entityList.stream().map(questionTransformer::transform)
				.collect(Collectors.toList());

	}	
	public List<Domain> findAllDomains() {
		List<DomainEntity> entityList = repo.findAllByOrderBySortOrderAsc();
		
		return entityList.stream().map(domainTransformer::transform)
				.collect(Collectors.toList());
	}
	
	public List<Domain> findAllConceptsByDomainId() {
		List<DomainEntity> domEntityList = repo.findAllByOrderBySortOrderAsc();
		
		
		for (DomainEntity de : domEntityList) {
			List<ConceptEntity> conceptList = conceptRepo.findAllByDomainId(de.id);
		}
		return domEntityList.stream().map(domainTransformer::transform)
				.collect(Collectors.toList());
	}
		
	public TraSession createTraSession() {
//		System.out.println("id length: " + this.sessionIdLength.intValue() + " feedback base: " +
//				this.feedbackProbabilityPossibleOutcomes.intValue() );
		
		String sessionId = RandomGenerator.getAlphaNumeric(this.sessionIdLength.intValue());
		TraSessionEntity traSessionEntity = new TraSessionEntity();
		traSessionEntity.setSessionId(sessionId);
		traSessionEntity.setStartTime(new Date());
		traSessionEntity.setLastUpdateTime(traSessionEntity.getStartTime());
		
		Random rand = new Random();
		boolean selectedForFeedback = rand.nextInt(this.feedbackProbabilityPossibleOutcomes)==0;
		traSessionEntity.setSelectedForFeedback(selectedForFeedback);
		
		TraSessionEntity result = traSessionRepo.saveAndFlush(traSessionEntity);
		
		return this.traSessionTransformer.transform(result);
		
	}
	
	@Transactional
	public TraSession saveTraSession(TraSession traSession) {
		
		traSessionRepo.deleteSessionAnswers(traSession.getSessionId());
		
		Collection<TraAnswer> allTheAnswers = traSession.getTraAnswers().values();
		for (TraAnswer answer: allTheAnswers) {
			List<TraOption> selectedOptions = answer.getSelectedOptions();
			for (TraOption aSelectedOption : selectedOptions) {
				traSessionRepo.addSelectedOption(traSession.getSessionId(), answer.getQuestion().getId(), aSelectedOption.getId()) ;
			}
		}
		
		return getTraSession(traSession.getSessionId());
	}	


	public TraSession getTraSession(String sessionId) {

		TraSessionEntity result = traSessionRepo.findBySessionId(sessionId);
		Calendar lastUpdatePlusTimeout = Calendar.getInstance();
		
		if (result != null) {
			lastUpdatePlusTimeout.setTime(result.getLastUpdateTime());
			lastUpdatePlusTimeout.add(Calendar.MINUTE, sessionTimeout);
			if (lastUpdatePlusTimeout.before(Calendar.getInstance()) ) {
				result.setExpired(true);
			}
			else {
				result.setExpired(false);
			}
		}
		
		TraSession traSession = this.traSessionTransformer.transform(result);
		
		
		List<Object[]> sessionQaResult = traSessionRepo.getSessionQuestionAnswers(sessionId);

		if (sessionQaResult != null && sessionQaResult.size() > 0) {
			HashMap<String, TraAnswer> qaMap = new HashMap<String, TraAnswer> ();
		
			sessionQaResult.stream().forEach((record) -> {
				Question q = (Question) record[0];
				TraOption a = (TraOption) record[1];

				TraAnswer currTraAnswer = qaMap.get(q.getId().toString());
		    
				if (currTraAnswer == null) {
					qaMap.put(q.getId().toString(), new TraAnswer());
					qaMap.get(q.getId().toString()).setQuestion(q);
					qaMap.get(q.getId().toString()).setSelectedOptions(new ArrayList<TraOption> ());
					
					currTraAnswer = qaMap.get(q.getId().toString());
				}
				
				
				currTraAnswer.getSelectedOptions().add(a);

			});
			traSession.setTraAnswers(qaMap);
		
		}
		return traSession; 
		
	}	
	
}
