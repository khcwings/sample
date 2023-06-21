package com.multi.sample.persistence.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.multi.sample"})
@EntityScan(basePackages = {"com.multi.sample.persistence.models"})
@EnableJpaRepositories(basePackages = {"com.multi.sample.persistence.repository.jpa"})
@EnableJpaAuditing
@MapperScan(basePackages = "com.multi.sample.persistence.repository.mybaties")
public class PersistenceConfig {
}
