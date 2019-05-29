package org.orbitshakers.tra.transformer;


import org.orbitshakers.tra.domain.Domain;
import org.orbitshakers.tra.entity.DomainEntity;

public class DomainTrans implements Transformer<DomainEntity, Domain>{
	
    @Override
    public Domain transform(DomainEntity entity){
        return new Domain(entity.getId(), entity.getName(), entity.getInstruction(), entity.getWeight(), entity.getSortOrder());
    }

    @Override
    public DomainEntity extract(Domain resource){
        
        DomainEntity entity = 
        	 new DomainEntity(resource.getId(), resource.getName(), resource.getInstruction(), resource.getWeight(), resource.getSortOrder());
        return entity;
    }
}
