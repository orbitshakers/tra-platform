package org.orbitshakers.tra.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TraOption {
//	id
//	name
//	point
//	sort_order

	private Long id;
	private String name;
	private Integer point;
	private Integer sortOrder;
	
	public TraOption (Long id) {
		this.id = id;
	}
}
