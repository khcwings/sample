package com.multi.sample.persistence.repository.jpa.aspect;

import com.multi.sample.persistence.models.aspect.SessionHist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionHistRepository extends JpaRepository<SessionHist, Long> {
}
