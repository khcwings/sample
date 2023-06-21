package com.multi.sample.persistence.repository.mybaties.sample;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SampleMybatiesRepository {
    List<Map<String, Object>> getSampleaList(Map<String, Object> param);
}
