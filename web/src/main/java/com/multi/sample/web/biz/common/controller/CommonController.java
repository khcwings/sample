package com.multi.sample.web.biz.common.controller;

import com.multi.sample.common.entity.ResultEntity;

import com.multi.sample.common.utils.DataUtil;
import com.multi.sample.persistence.service.sample.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;

@Controller
public class CommonController {
    protected Logger LOG = LoggerFactory.getLogger(CommonController.class);

    @Value("${server.language.list}")
    private String languageList;

    private final SampleService sampleService;

    public CommonController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    /**
     * 다국어 언어를 변경한다.
     * 소스상에 지정된 언어로만 변경이 가능하다.
     */
    @RequestMapping(value = {"/common/changeLanguage"}, method = RequestMethod.POST)
    public @ResponseBody ResultEntity<Object> changeLanguage(@RequestBody Map<String, Object> inParam, HttpSession session) {
        String changeLanguage = DataUtil.getMapToString(inParam, "changeLanguage");
        if(languageList.indexOf(changeLanguage) > -1) {
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale(changeLanguage));
        } else {
            return ResultEntity.fail(null);
        }
        return new ResultEntity();
    }
}
