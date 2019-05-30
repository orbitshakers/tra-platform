package org.orbitshakers.tra.repo;

import java.util.List;

import org.orbitshakers.tra.entity.ConceptEntity;
import org.orbitshakers.tra.entity.QuestionEntity;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepo extends ReadOnlyRepo<QuestionEntity, Long> {   
    
    @Query(value = "SELECT q.* FROM question q WHERE q.question_type_id = ?1", 
    		  nativeQuery = true)
    public List<QuestionEntity> findAllByQuestionTypeId(Long id);
    
    
}