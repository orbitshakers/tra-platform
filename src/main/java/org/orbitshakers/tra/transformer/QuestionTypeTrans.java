package org.orbitshakers.tra.transformer;


import org.orbitshakers.tra.domain.QuestionType;
import org.orbitshakers.tra.domain.TraOption;
import org.orbitshakers.tra.entity.QuestionTypeEntity;
import org.orbitshakers.tra.entity.TraOptionEntity;

public class QuestionTypeTrans implements Transformer<QuestionTypeEntity, QuestionType>{
//	id
//	name

	
    @Override
    public QuestionType transform(QuestionTypeEntity entity){
        return new QuestionType(entity.getId(), entity.getName());
    }

    @Override
    public QuestionTypeEntity extract(QuestionType resource){
    	QuestionTypeEntity entity = 
        	 new QuestionTypeEntity(resource.getId(), resource.getName());
        return entity;
    }
}
