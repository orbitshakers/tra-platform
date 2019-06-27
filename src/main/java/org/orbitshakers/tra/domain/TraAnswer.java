package org.orbitshakers.tra.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TraAnswer {
	private Question question;
	private List<TraOption> selectedOptions;
}
