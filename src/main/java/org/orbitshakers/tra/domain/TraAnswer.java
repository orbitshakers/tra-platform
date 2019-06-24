package org.orbitshakers.tra.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TraAnswer {
	private Question question;
	private TraOption[] selectedOptions;
}
