package org.orbitshakers.tra.service;

import java.util.List;

import org.orbitshakers.tra.domain.Domain;
import org.orbitshakers.tra.domain.Question;
import org.orbitshakers.tra.domain.Questionnaire;
import org.orbitshakers.tra.domain.TraSession;

public interface TraService {

	public List<Domain> findAllDomains();	
	public List<Question> findAllStandaloneQuestions();
	public List<Question> findAllFeedbackQuestions();
	
	public Questionnaire getQuestionnaire();
	
	public TraSession createTraSession();
	
	public TraSession saveTraSession(TraSession traSession);
	
}
