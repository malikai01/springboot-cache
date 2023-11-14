package com.mlk.cache.springbootcache.delay;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @author ****
 * @date 2021/7/14
 */
@Configuration
public class RedissonConfig {


    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() throws IOException {
        Config config = Config.fromYAML(new ClassPathResource("redisson/redisson-single.yml").getInputStream());
        return Redisson.create(config);
    }
}
