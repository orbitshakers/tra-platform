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
import javax.persistence.Table;

import org.orbitshakers.tra.domain.TraOption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "concept")
@ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ConceptEntity {

//	id
//	name
//	explanation
//	instruction
//	unnamed
//	weight_perc
//	sort_order

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id")
	public Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "explanation")
	private String explanation;
	
	@Column(name = "instruction")
	private String instruction;

	@Column(name = "unnamed")
	private boolean unnamed;
	
	@Column(name = "weight_perc")
	private Double weight;
	
	@Column(name = "sort_order")
	private Integer sortOrder;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "concept_traoption",
			joinColumns = @JoinColumn(name = "concept_id"),
			inverseJoinColumns = @JoinColumn(name = "traoption_id")
			)	
	private List<TraOptionEntity> traOptions;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "concept_question",
			joinColumns = @JoinColumn(name = "concept_id"),
			inverseJoinColumns = @JoinColumn(name = "question_id")
			)	
	private List<QuestionEntity> questions;	
}
