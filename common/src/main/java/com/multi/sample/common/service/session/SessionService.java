package com.multi.sample.common.service.session;

import com.multi.sample.common.entity.session.UserSession;

public interface SessionService {
    void saveUserSession(UserSession userSession);

    void removeUserSession(String id);

    UserSession getUserSession(String id);

    String createSessionId(String preFix);
}
