package org.orbitshakers.tra.transformer;


import org.orbitshakers.tra.domain.Concept;
import org.orbitshakers.tra.domain.TraOption;
import org.orbitshakers.tra.entity.ConceptEntity;
import org.orbitshakers.tra.entity.TraOptionEntity;

public class TraOptionTrans implements Transformer<TraOptionEntity, TraOption>{
//	id
//	name
//	point
//	sort_order
	
    @Override
    public TraOption transform(TraOptionEntity entity){
        return new TraOption(entity.getId(), entity.getName(), entity.getPoint(), entity.getSortOrder());
    }

    @Override
    public TraOptionEntity extract(TraOption resource){
    	TraOptionEntity entity = 
        	 new TraOptionEntity(resource.getId(), resource.getName(), resource.getPoint(), resource.getSortOrder());
        return entity;
    }
}
