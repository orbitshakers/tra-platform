package org.orbitshakers.tra.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "trasession")
@ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TraSessionEntity {
/*
 * session_id
start_time
end_time
completed
selected_for_feedback
score
 */
	
	@Id	
	@Column(name = "session_id")
	public String sessionId;

	@Column(name = "start_time")
	private Date startTime;

	@Column(name = "end_time")
	private Date endTime;

	@Column(name = "last_update_time")
	private Date lastUpdateTime;
	
	@Column(name = "completed")
	private boolean completed;

	@Column(name = "selected_for_feedback")
	private boolean selectedForFeedback;

	

	@Column(name = "score")
	private Double score;

/*
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "domain_concept",
			joinColumns = @JoinColumn(name = "domain_id"),
			inverseJoinColumns = @JoinColumn(name = "concept_id")
			)
	private List<ConceptEntity> concepts;
	*/
}
