package org.orbitshakers.tra.entity;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.orbitshakers.tra.domain.Question;
import org.orbitshakers.tra.domain.TraAnswer;
import org.orbitshakers.tra.domain.TraOption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SqlResultSetMapping(
        name="sessionQuestionAnswerMapping",
        classes={
           @ConstructorResult(
                targetClass=Question.class,
                  columns={
                     @ColumnResult(name="question_id", type=Long.class)
                     }
           ),
           @ConstructorResult(
        		   targetClass=TraOption.class,
        		   columns={
        				   @ColumnResult(name="traoption_id", type=Long.class)
        		   }
           )

        }
)
@NamedNativeQuery(name="TraSessionEntity.getSessionQuestionAnswers", 
     resultSetMapping="sessionQuestionAnswerMapping", 
     query="SELECT question_id, traoption_id from trasess_quest_traop WHERE session_id = ?1")

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

	@Transient
	private HashMap<String, TraAnswer> traAnswers;
	
	@Transient
	private boolean expired;
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
