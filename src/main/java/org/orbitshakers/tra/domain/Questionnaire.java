package org.orbitshakers.tra.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter @NoArgsConstructor  @AllArgsConstructor
public class Questionnaire {

	private List<Question> standaloneQuestions;
	private List<Domain> domains;
	private List<Question> feedbackQuestions;
	
}
