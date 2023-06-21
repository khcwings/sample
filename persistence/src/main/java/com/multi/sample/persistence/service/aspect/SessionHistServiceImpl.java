package com.multi.sample.persistence.service.aspect;

import com.multi.sample.persistence.models.aspect.SessionHist;
import com.multi.sample.persistence.repository.jpa.aspect.SessionHistRepository;
import com.multi.sample.persistence.service.common.BaseServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SessionHistServiceImpl extends BaseServiceImpl<SessionHist> implements SessionHistService {
    private final SessionHistRepository sessionHistRepository;

    public SessionHistServiceImpl(JpaRepository<SessionHist, Long> repository, SessionHistRepository sessionHistRepository) {
        super(repository);
        this.sessionHistRepository = sessionHistRepository;
    }
}
