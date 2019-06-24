package org.orbitshakers.tra.transformer;


import java.util.Date;
import java.util.stream.Collectors;

import org.orbitshakers.tra.domain.Concept;
import org.orbitshakers.tra.domain.Question;
import org.orbitshakers.tra.domain.TraOption;
import org.orbitshakers.tra.domain.TraSession;
import org.orbitshakers.tra.entity.ConceptEntity;
import org.orbitshakers.tra.entity.QuestionEntity;
import org.orbitshakers.tra.entity.TraOptionEntity;
import org.orbitshakers.tra.entity.TraSessionEntity;

public class TraSessionTrans implements Transformer<TraSessionEntity, TraSession>{
	private Transformer<TraOptionEntity, TraOption> traOptionTransformer = new TraOptionTrans();
	private Transformer<QuestionEntity, Question> questionTransformer = new QuestionTrans();
    @Override
    public TraSession transform(TraSessionEntity entity){
/*
 * 	private String sessionId;
	private Date startTime;
	private Date endTime;
	private Date lastUpdateTime;
	private boolean completed;
	private boolean selectedForFeedback;
	private Double score;    	
 */
    	
        return new TraSession(entity.getSessionId(), entity.getStartTime(), entity.getEndTime(),
        		entity.getLastUpdateTime(), entity.isCompleted(), entity.isSelectedForFeedback(), entity.getScore(), null
//entity.getTraOptions().stream().map(traOptionTransformer::transform).collect(Collectors.toList()),
//entity.getQuestions().stream().map(questionTransformer::transform).collect(Collectors.toList())
        		);
    }

    @Override
    public TraSessionEntity extract(TraSession resource){
    	TraSessionEntity entity = 
    			new TraSessionEntity(resource.getSessionId(), resource.getStartTime(), resource.getEndTime(),
    					resource.getLastUpdateTime(), resource.isCompleted(), resource.isSelectedForFeedback(), resource.getScore(), null
//    					resource.getTraOptions().stream().map(traOptionTransformer::extract).collect(Collectors.toList()),
//    					resource.getQuestions().stream().map(questionTransformer::extract).collect(Collectors.toList())
    					);
    	return entity;
    }
}
