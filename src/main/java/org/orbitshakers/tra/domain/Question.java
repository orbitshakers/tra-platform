package org.orbitshakers.tra.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Question {
//	id
//	name
//	title
//	question_type_id
//	multi_answer
//	explanation
//	instruction
//	text
//	sort_order
	
	private Long id;
	private String name;
	private String title;
	private QuestionType questionType;
	private boolean multiAnswer;
	private String explanation;
	private String instruction;
	private String text;
	private Integer sortOrder;
	private List<TraOption> traOptions;
}
