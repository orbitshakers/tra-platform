package org.orbitshakers.tra.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.orbitshakers.tra.domain.QuestionType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "question")
@ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class QuestionEntity {

//	id
//	name
//	title
//	question_type_id
//	multi_answer
//	explanation
//	instruction
//	text
//	sort_order

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id")
	public Long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "title")
	private String title;	


	@OneToOne(cascade = CascadeType.ALL)
    
    @JoinColumn(name = "question_type_id", referencedColumnName = "id")
	private QuestionTypeEntity questionType;
	
	@Column(name = "multi_answer")
	private boolean multiAnswer;
	
	@Column(name = "explanation")
	private String explanation;
	
	@Column(name = "instruction")
	private String instruction;

	@Column(name = "text")
	private String text;
	
	
	@Column(name = "sort_order")
	private Integer sortOrder;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "question_traoption",
			joinColumns = @JoinColumn(name = "question_id"),
			inverseJoinColumns = @JoinColumn(name = "traoption_id")
			)	
	private List<TraOptionEntity> traOptions;
}
