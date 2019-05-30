package org.orbitshakers.tra.transformer;


import java.util.stream.Collectors;

import org.orbitshakers.tra.domain.Concept;
import org.orbitshakers.tra.domain.Domain;
import org.orbitshakers.tra.entity.ConceptEntity;
import org.orbitshakers.tra.entity.DomainEntity;

public class DomainTrans implements Transformer<DomainEntity, Domain>{
	private Transformer<ConceptEntity, Concept> conceptTransformer = new ConceptTrans();
	
    @Override
    public Domain transform(DomainEntity entity){
        return new Domain(entity.getId(), entity.getName(), entity.getInstruction(), entity.getWeight(), entity.getSortOrder(), 
        		entity.getConcepts().stream().map(conceptTransformer::transform).collect(Collectors.toList())
        		);
    }

    @Override
    public DomainEntity extract(Domain resource){
        
        DomainEntity entity = 
        	 new DomainEntity(resource.getId(), resource.getName(), resource.getInstruction(), resource.getWeight(), resource.getSortOrder(), 
        			 resource.getConcepts().stream().map(conceptTransformer::extract).collect(Collectors.toList())
        			 );
        return entity;
    }
}
