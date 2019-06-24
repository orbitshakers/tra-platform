package org.orbitshakers.tra.repo;

import org.orbitshakers.tra.entity.TraSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TraSessionRepo extends JpaRepository<TraSessionEntity, Long> {
    @Query("SELECT traSession FROM TraSessionEntity traSession WHERE traSession.sessionId = ?1")
    TraSessionEntity findBySessionId(String sessionId);
    
	@Modifying
	@Query(value="DELETE FROM trasess_quest_traop WHERE session_id =?1 ", nativeQuery = true)
	void deleteSessionAnswers(String sessionId);
	
	@Modifying
	@Query(value="INSERT INTO trasess_quest_traop(session_id, question_id, traoption_id) VALUES (?1, ?2, ?3) ", nativeQuery = true)
	void addSelectedOption(String sessionId, Long questionId, Long traOptionId) ;
}