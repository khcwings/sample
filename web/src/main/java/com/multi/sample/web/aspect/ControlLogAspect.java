package com.multi.sample.web.aspect;

import com.multi.sample.common.utils.HttpServletRequestUtil;
import com.multi.sample.persistence.models.aspect.SessionHist;
import com.multi.sample.persistence.service.aspect.SessionHistService;
import org.apache.commons.io.IOUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@Aspect
public class ControlLogAspect {
    protected Logger LOG = LoggerFactory.getLogger(ControlLogAspect.class);

    @Autowired
    private SessionHistService sessionHistService;

    @Before("execution(* com.multi.sample..*Controller.*(..))")
    public void beforeControllerLog(JoinPoint jp) {
        SessionHist sessionHist = new SessionHist();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        //LOG.debug("### getMethod => {}", request.getMethod());
        //LOG.debug("### getMethod => {}", request.getMethod());
        Object[] args = jp.getArgs();
        LOG.info("### AOP Args => {}", args.length);
        LOG.info("### User-Agent => {}", request.getHeader("User-Agent"));

/*
        for(Object obj : args) {
            LOG.debug("### {}", (obj instanceof HttpServletRequest));
            if(obj instanceof HttpServletRequest) {
                request = (HttpServletRequest)obj;
            }
        }*/
        HttpSession session = request.getSession(true);
        sessionHist.setSessionId(session.getId());
        sessionHist.setRequestUrl(request.getRequestURI());
        sessionHist.setRequestMethod(request.getMethod());
        sessionHist.setClientIp(HttpServletRequestUtil.getClientIpAddr(request));
        sessionHist.setClientOs(HttpServletRequestUtil.getClientOs(request));
        sessionHist.setClientBrowser(HttpServletRequestUtil.getClientBrowser(request));
        sessionHist.setClientWebType(HttpServletRequestUtil.getClientWebType(request));
        if("POST".equals(request.getMethod().toUpperCase())) {
            try {
                sessionHist.setRequestBody(IOUtils.toString(request.getReader()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            sessionHist.setRequestBody(HttpServletRequestUtil.getRequestParamMapToString(request));
        }
        // TODO : User 로그인 정보 추가

        LOG.info("### {}", sessionHist.toString());
        sessionHistService.saveOrUpdate(sessionHist);
    }
}
