package com.multi.sample.web.biz.sample.controller;

import com.multi.sample.common.entity.ResultEntity;
import com.multi.sample.common.entity.session.UserSession;
import com.multi.sample.common.service.session.SessionService;
import com.multi.sample.common.utils.DataUtil;
import com.multi.sample.persistence.service.sample.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/sample")
public class SampleController {
    protected Logger LOG = LoggerFactory.getLogger(SampleController.class);

    private final SampleService sampleService;

    private final SessionService sessionService;

    public SampleController(SampleService sampleService, SessionService sessionService) {
        this.sampleService = sampleService;
        this.sessionService = sessionService;
    }

    @GetMapping("/")
    public String index() {
        LOG.debug("###### START ######");
        return "index";
    }

    @RequestMapping(value = {"/getSample"}, method = RequestMethod.POST)
    public @ResponseBody ResultEntity<Object> changeLanguage(@RequestBody Map<String, Object> inParam) {

        List<Map<String, Object>> result = sampleService.getSampleaList(inParam);

        return new ResultEntity(result);
    }

    @RequestMapping(value = {"/createSession"}, method = RequestMethod.POST)
    public @ResponseBody ResultEntity<Object> createSession(@RequestBody Map<String, Object> inParam) {

        UserSession userSession = new UserSession();
        userSession.setId(sessionService.createSessionId(DataUtil.getMapToString(inParam, "preFix")));
        sessionService.saveUserSession(userSession);

        return new ResultEntity(null);
    }

    @RequestMapping(value = {"/getUserSession"}, method = RequestMethod.POST)
    public @ResponseBody ResultEntity<Object> getUserSession(@RequestBody Map<String, Object> inParam) {

        UserSession userSession = sessionService.getUserSession(DataUtil.getMapToString(inParam, "sessionKey"));

        return new ResultEntity(userSession);
    }

    @RequestMapping(value = {"/removeUserSession"}, method = RequestMethod.POST)
    public @ResponseBody ResultEntity<Object> removeUserSession(@RequestBody Map<String, Object> inParam) {

        sessionService.removeUserSession(DataUtil.getMapToString(inParam, "sessionKey"));

        return new ResultEntity(null);
    }
}
