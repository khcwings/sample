package com.multi.sample.persistence.repository.jpa.sample;

import com.multi.sample.persistence.models.sample.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

}
