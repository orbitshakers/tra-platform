package org.orbitshakers.tra.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "question_type")
@ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class QuestionTypeEntity {
//	id
//	name

	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id")
	public Long id;

	@Column(name = "name")
	private String name;



}
