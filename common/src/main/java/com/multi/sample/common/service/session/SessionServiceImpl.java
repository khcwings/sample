package com.multi.sample.common.service.session;

import com.multi.sample.common.entity.session.UserSession;
import com.multi.sample.common.service.RedisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class SessionServiceImpl implements SessionService {

    @Value("${redis.session.expired.second:1800}") // Default 1800초 설정
    private long expiredSeconds;

    private final RedisService redisService;

    public SessionServiceImpl(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public void saveUserSession(UserSession userSession) {
        redisService.putExpired(userSession.getId(), userSession, expiredSeconds, TimeUnit.SECONDS);
    }

    @Override
    public void removeUserSession(String id) {
        redisService.remove(id);
    }

    @Override
    public UserSession getUserSession(String id) {
        return redisService.get(id);
    }


    /**
     * UUID 기반의 Session ID 값을 생성한다.
     * @param preFix
     * @return
     */
    @Override
    public String createSessionId(String preFix) {
        String sessionPreFix = "";
        if(preFix == null || "".equals(preFix)) {
            sessionPreFix = System.getProperty("sessionPreFix", "unkonwn");
        } else {
            sessionPreFix = preFix;
        }

        return String.format("%s_%s", sessionPreFix, UUID.randomUUID().toString().replaceAll("-", ""));
    }
}
