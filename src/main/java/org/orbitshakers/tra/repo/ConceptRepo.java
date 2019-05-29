package org.orbitshakers.tra.repo;

import java.util.List;

import org.orbitshakers.tra.entity.DomainEntity;

public interface ConceptRepo extends ReadOnlyRepo<DomainEntity, Long> {
    public List<DomainEntity> findAll();
    
    public List<DomainEntity> findAllByOrderByIdDesc();  
}