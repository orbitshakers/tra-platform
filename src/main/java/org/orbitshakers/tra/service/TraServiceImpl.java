package org.orbitshakers.tra.service;

import java.util.List;
import java.util.stream.Collectors;

import org.orbitshakers.tra.domain.Domain;
import org.orbitshakers.tra.domain.Question;
import org.orbitshakers.tra.domain.Questionnaire;
import org.orbitshakers.tra.entity.ConceptEntity;
import org.orbitshakers.tra.entity.DomainEntity;
import org.orbitshakers.tra.entity.QuestionEntity;
import org.orbitshakers.tra.repo.ConceptRepo;
import org.orbitshakers.tra.repo.DomainRepo;
import org.orbitshakers.tra.repo.QuestionRepo;
import org.orbitshakers.tra.transformer.DomainTrans;
import org.orbitshakers.tra.transformer.QuestionTrans;
import org.orbitshakers.tra.transformer.Transformer;
import org.springframework.stereotype.Service;

@Service
public class TraServiceImpl implements TraService{

	private Transformer<DomainEntity, Domain> domainTransformer = new DomainTrans();
	private Transformer<QuestionEntity, Question> questionTransformer = new QuestionTrans();
	
	private final DomainRepo repo;
	private final ConceptRepo conceptRepo;
	private final QuestionRepo questionRepo;

	public TraServiceImpl(DomainRepo repo, ConceptRepo conceptRepo, QuestionRepo questionRepo) {

		this.repo = repo;
		this.conceptRepo = conceptRepo;
		this.questionRepo = questionRepo;
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
		

}
