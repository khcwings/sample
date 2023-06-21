package com.multi.sample.scheduler.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Profile("scheduler")
public class SampleProcessingTask {
    protected Logger LOG = LoggerFactory.getLogger(SampleProcessingTask.class);


    @Scheduled(fixedDelayString = "100000", initialDelayString = "5000")
    public void sampleSchedulerWork() {
        LOG.debug("### Sample Scheduler Work");
    }
}
