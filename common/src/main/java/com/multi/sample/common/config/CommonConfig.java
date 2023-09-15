package com.multi.sample.common.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.multi.sample"})
@EntityScan(basePackages = {"com.multi.sample.common"})
public class CommonConfig {
}
