package com.multi.sample.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import javax.inject.Inject;
import java.time.Duration;
import java.util.Arrays;

@Configuration
public class RedisConfig {
    @Value("${redis.pool.max}")
    private int redisPoolMax;

    @Value("${redis.pool.min-idle}")
    private int redisPoolMinIdle;

    @Value("${redis.pool.max-idle}")
    private int redisPoolMaxIdle;

    @Value("${redis.hosts}")
    private String[] redisHosts;

    @Value("${redis.port}")
    private int redisMasterPort;

    @Value("${redis.connection-time-out}")
    private int redisConnTimeout;

    private final ObjectMapper mapper;

    @Inject
    public RedisConfig(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(redisPoolMax);
        poolConfig.setMinIdle(redisPoolMinIdle);
        poolConfig.setMaxIdle(redisPoolMaxIdle);
        poolConfig.setTestOnBorrow(false);
        poolConfig.setTestOnReturn(false);


        JedisClientConfiguration.JedisClientConfigurationBuilder clientConfig = JedisClientConfiguration.builder();
        clientConfig.connectTimeout(Duration.ofMillis(redisConnTimeout));
        clientConfig.usePooling().poolConfig(poolConfig);

        JedisConnectionFactory jedisConnectionFactory;
        if(redisHosts.length == 1) {
            RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
            redisConfig.setHostName(redisHosts[0]);
            redisConfig.setPort(redisMasterPort);

            jedisConnectionFactory = new JedisConnectionFactory(redisConfig, clientConfig.build());
        } else {
            RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(Arrays.asList(redisHosts));
            jedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration, clientConfig.build());
        }

        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer(mapper));
        redisTemplate.setEnableTransactionSupport(true);
        return redisTemplate;
    }

}
