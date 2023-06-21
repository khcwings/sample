package com.multi.sample.persistence.service.sample;

import com.multi.sample.persistence.models.sample.Sample;
import com.multi.sample.persistence.service.common.BaseService;

import java.util.List;
import java.util.Map;

public interface SampleService extends BaseService<Sample> {
    List<Map<String, Object>> getSampleaList(Map<String, Object> inParam);
}
