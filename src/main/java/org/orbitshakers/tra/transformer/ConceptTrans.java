package org.orbitshakers.tra.transformer;


import java.util.stream.Collectors;

import org.orbitshakers.tra.domain.Concept;
import org.orbitshakers.tra.domain.Question;
import org.orbitshakers.tra.domain.TraOption;
import org.orbitshakers.tra.entity.ConceptEntity;
import org.orbitshakers.tra.entity.QuestionEntity;
import org.orbitshakers.tra.entity.TraOptionEntity;

public class ConceptTrans implements Transformer<ConceptEntity, Concept>{
	private Transformer<TraOptionEntity, TraOption> traOptionTransformer = new TraOptionTrans();
	private Transformer<QuestionEntity, Question> questionTransformer = new QuestionTrans();
    @Override
    public Concept transform(ConceptEntity entity){
        return new Concept(entity.getId(), entity.getName(), entity.getExplanation(),
        		entity.getInstruction(), entity.isUnnamed(), entity.getWeight(), entity.getSortOrder(),
        		entity.getTraOptions().stream().map(traOptionTransformer::transform).collect(Collectors.toList()),
        		entity.getQuestions().stream().map(questionTransformer::transform).collect(Collectors.toList())
        		);
    }

    @Override
    public ConceptEntity extract(Concept resource){
    	ConceptEntity entity = 
    			new ConceptEntity(resource.getId(), resource.getName(), resource.getExplanation(),
    					resource.getInstruction(), resource.isUnnamed(), resource.getWeight(), resource.getSortOrder(),
    					resource.getTraOptions().stream().map(traOptionTransformer::extract).collect(Collectors.toList()),
    					resource.getQuestions().stream().map(questionTransformer::extract).collect(Collectors.toList())
    					);
    	return entity;
    }
}
