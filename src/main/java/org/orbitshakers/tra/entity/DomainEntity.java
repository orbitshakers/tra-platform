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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "domain")
@ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DomainEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id")
	public Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "instruction")
	private String instruction;

	@Column(name = "weight_perc")
	private Double weight;
	
	@Column(name = "sort_order")
	private Integer sortOrder;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "domain_concept",
			joinColumns = @JoinColumn(name = "domain_id"),
			inverseJoinColumns = @JoinColumn(name = "concept_id")
			)
	private List<ConceptEntity> concepts;
}
