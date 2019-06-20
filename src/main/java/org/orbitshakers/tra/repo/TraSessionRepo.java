package org.orbitshakers.tra.repo;

import org.orbitshakers.tra.entity.TraSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraSessionRepo extends JpaRepository<TraSessionEntity, Long> {
}