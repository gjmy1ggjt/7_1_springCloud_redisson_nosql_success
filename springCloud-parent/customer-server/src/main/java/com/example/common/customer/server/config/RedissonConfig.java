package com.example.common.customer.server.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * Created by Administrator on 2020/1/28.
 */
@Configuration
public class RedissonConfig {

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() throws IOException {
        // 1. 创建Config对象，读取配置属性
        // 2. 创建Redisson对象,传入Config对象
        RedissonClient redisson = Redisson.create(Config.fromYAML(
                new ClassPathResource("redisson.yml").getInputStream()));
        return redisson;
    }
}
