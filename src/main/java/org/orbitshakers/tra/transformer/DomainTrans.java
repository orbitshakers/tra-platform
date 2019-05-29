package org.orbitshakers.tra.transformer;


import org.orbitshakers.tra.domain.Domain;
import org.orbitshakers.tra.entity.DomainEntity;

public class DomainTrans implements Transformer<DomainEntity, Domain>{
//	private Long id;
//	private String name;
//	private String instruction;
//	private Double weight;
	
    @Override
    public Domain transform(DomainEntity entity){
        return new Domain(entity.getId(), entity.getName(), entity.getInstruction(), entity.getWeight());
    }

    @Override
    public DomainEntity extract(Domain resource){
        Long id = resource.getId() == null ? null : Long.valueOf(resource.getId());
        DomainEntity entity = 
        	 new DomainEntity(resource.getId(), resource.getName(), resource.getInstruction(), resource.getWeight());
        return entity;
    }
}
