package org.orbitshakers.tra.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Concept {
//	id
//	name
//	explanation
//	instruction
//	unnamed
//	weight_perc
//	sort_order
	
	private Long id;
	private String name;
	private String explanation;
	private String instruction;
	private boolean unnamed;
	private Double weight;
	private Integer sortOrder;
}
