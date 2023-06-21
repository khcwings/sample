package com.multi.sample.persistence.models.aspect;

import com.multi.sample.persistence.models.common.AuditableEntity;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class SessionHist extends AuditableEntity {

    private static final long serialVersionUID = 5888080633783212329L;

    @Column(length = 128, nullable = false, name = "session_id")
    private String SessionId;

    @Column(length = 1024, nullable = false, name = "request_url")
    private String requestUrl;

    @Column(length = 8, name = "request_method")
    private String requestMethod;

    @Column(columnDefinition = "TEXT", name = "request_body")
    private String requestBody;

    @Column(length = 24, nullable = false, name = "client_ip")
    private String clientIp;

    @Column(length = 32, name = "client_os")
    private String clientOs;

    @Column(length = 32, name = "client_browser")
    private String clientBrowser;

    @Column(length = 16, name = "client_web_type")
    private String clientWebType;

    public String getSessionId() {
        return SessionId;
    }

    public void setSessionId(String sessionId) {
        SessionId = sessionId;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getClientOs() {
        return clientOs;
    }

    public void setClientOs(String clientOs) {
        this.clientOs = clientOs;
    }

    public String getClientBrowser() {
        return clientBrowser;
    }

    public void setClientBrowser(String clientBrowser) {
        this.clientBrowser = clientBrowser;
    }

    public String getClientWebType() {
        return clientWebType;
    }

    public void setClientWebType(String clientWebType) {
        this.clientWebType = clientWebType;
    }

    @Override
    public String toString() {
        return "SessionHist{" +
                "SessionId='" + SessionId + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                ", requestMethod='" + requestMethod + '\'' +
                ", requestBody='" + requestBody + '\'' +
                ", clientIp='" + clientIp + '\'' +
                ", clientOs='" + clientOs + '\'' +
                ", clientBrowser='" + clientBrowser + '\'' +
                ", clientWebType='" + clientWebType + '\'' +
                '}';
    }
}
