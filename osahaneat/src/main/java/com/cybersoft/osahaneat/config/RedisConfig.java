package com.cybersoft.osahaneat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private int port;

    //Tao connect toi he thong redis
    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(host, port);

//        redisStandaloneConfiguration.setDatabase(0); // Chi dinh database su dung trong redis
//        redisStandaloneConfiguration.setUsername(""); // Thong tin tk dang nhap vao redis
//        redisStandaloneConfiguration.setPassword(""); // Thong tin mk cua tk dang nhap redis

        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }

    //Tao template de thuc hien them xoa sua tren redis
    @Bean
    @Primary
    public RedisTemplate<Object, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(lettuceConnectionFactory);

        return redisTemplate;
    }

}
