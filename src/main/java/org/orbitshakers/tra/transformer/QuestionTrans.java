package org.orbitshakers.tra.transformer;


import java.util.stream.Collectors;

import org.orbitshakers.tra.domain.Concept;
import org.orbitshakers.tra.domain.Question;
import org.orbitshakers.tra.domain.QuestionType;
import org.orbitshakers.tra.domain.TraOption;
import org.orbitshakers.tra.entity.ConceptEntity;
import org.orbitshakers.tra.entity.QuestionEntity;
import org.orbitshakers.tra.entity.QuestionTypeEntity;
import org.orbitshakers.tra.entity.TraOptionEntity;

public class QuestionTrans implements Transformer<QuestionEntity, Question>{
//	id
//	name
//	title
//	question_type_id
//	multi_answer
//	explanation
//	instruction
//	text
//	sort_order
	
	private Transformer<QuestionTypeEntity, QuestionType> questionTypeTransformer = new QuestionTypeTrans();
	private Transformer<TraOptionEntity, TraOption> traOptionTransformer = new TraOptionTrans();
    @Override
    public Question transform(QuestionEntity entity){
        return new Question(entity.getId(), entity.getName(), entity.getTitle(), 
        		questionTypeTransformer.transform(entity.getQuestionType()),
        		entity.isMultiAnswer(), entity.getExplanation(),
        		entity.getInstruction(), entity.getText(), entity.getSortOrder(),
        		entity.getTraOptions().stream().map(traOptionTransformer::transform).collect(Collectors.toList())
        		);
    }

    @Override
    public QuestionEntity extract(Question resource){
    	QuestionEntity entity = 
    			new QuestionEntity(resource.getId(), resource.getName(), resource.getTitle(), 
    					questionTypeTransformer.extract(resource.getQuestionType()),
    					resource.isMultiAnswer(), resource.getExplanation(),
    					resource.getInstruction(), resource.getText(), resource.getSortOrder(), 
    					resource.getTraOptions().stream().map(traOptionTransformer::extract).collect(Collectors.toList())    					
    					);
        return entity;
    }
}
