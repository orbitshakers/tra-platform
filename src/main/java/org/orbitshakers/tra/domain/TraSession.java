package org.orbitshakers.tra.domain;

import java.util.Date;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TraSession {

	private String sessionId;
	private Date startTime;
	private Date endTime;
	private Date lastUpdateTime;
	private boolean completed;
	private boolean selectedForFeedback;
	private Double score;
	private HashMap<String, TraAnswer> traAnswers;
}
