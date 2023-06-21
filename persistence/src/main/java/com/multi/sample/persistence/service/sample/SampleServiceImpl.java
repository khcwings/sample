package com.multi.sample.persistence.service.sample;

import com.multi.sample.persistence.models.sample.Sample;
import com.multi.sample.persistence.repository.mybaties.sample.SampleMybatiesRepository;
import com.multi.sample.persistence.repository.jpa.sample.SampleRepository;
import com.multi.sample.persistence.service.common.BaseServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class SampleServiceImpl extends BaseServiceImpl<Sample> implements SampleService {

    private final SampleRepository sampleRepository;
    private final SampleMybatiesRepository sampleMybatiesRepository;

    public SampleServiceImpl(JpaRepository<Sample, Long> repository, SampleRepository sampleRepository, SampleMybatiesRepository sampleMybatiesRepository) {
        super(repository);
        this.sampleRepository = sampleRepository;
        this.sampleMybatiesRepository = sampleMybatiesRepository;
    }

    @Override
    public List<Map<String, Object>> getSampleaList(Map<String, Object> inParam) {
        return sampleMybatiesRepository.getSampleaList(inParam);
    }
}
