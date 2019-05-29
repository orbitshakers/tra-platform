package org.orbitshakers.tra.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Domain {

	private Long id;
	private String name;
	private String instruction;
	private Double weight;

}
