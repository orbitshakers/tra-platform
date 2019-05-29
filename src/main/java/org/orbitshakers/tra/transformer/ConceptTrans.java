package org.orbitshakers.tra.transformer;


import org.orbitshakers.tra.domain.Concept;
import org.orbitshakers.tra.entity.ConceptEntity;

public class ConceptTrans implements Transformer<ConceptEntity, Concept>{
//	id
//	name
//	explanation
//	instruction
//	unnamed
//	weight_perc
//	sort_order
    @Override
    public Concept transform(ConceptEntity entity){
        return new Concept(entity.getId(), entity.getName(), entity.getExplanation(),
        		entity.getInstruction(), entity.isUnnamed(), entity.getWeight(), entity.getSortOrder());
    }

    @Override
    public ConceptEntity extract(Concept resource){
        ConceptEntity entity = 
        	 new ConceptEntity(resource.getId(), resource.getName(), resource.getExplanation(),
        			 resource.getInstruction(), resource.isUnnamed(), resource.getWeight(), resource.getSortOrder());
        return entity;
    }
}
