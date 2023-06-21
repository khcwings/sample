package com.multi.sample.web.biz.sample.controller;

import com.multi.sample.common.entity.ResultEntity;
import com.multi.sample.common.utils.DataUtil;
import com.multi.sample.persistence.service.sample.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/sample")
public class SampleController {
    protected Logger LOG = LoggerFactory.getLogger(SampleController.class);

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/")
    public String index() {
        LOG.debug("###### START ######");
        return "index";
    }

    @RequestMapping(value = {"/getSample"}, method = RequestMethod.POST)
    public @ResponseBody ResultEntity<Object> changeLanguage(@RequestBody Map<String, Object> inParam, HttpSession session) {

        List<Map<String, Object>> result = sampleService.getSampleaList(inParam);

        return new ResultEntity(result);
    }
}
