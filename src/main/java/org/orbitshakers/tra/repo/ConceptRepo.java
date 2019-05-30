package org.orbitshakers.tra.repo;

import java.util.List;

import org.orbitshakers.tra.entity.ConceptEntity;
import org.springframework.data.jpa.repository.Query;

public interface ConceptRepo extends ReadOnlyRepo<ConceptEntity, Long> {
    public List<ConceptEntity> findAll();
    
    @Query(value = "SELECT c.* FROM concept c,  domain_concept dc WHERE dc.domain_id = ?1 AND c.id = dc.concept_id", 
    		  nativeQuery = true)
    public List<ConceptEntity> findAllByDomainId(Long id);
    
    
}