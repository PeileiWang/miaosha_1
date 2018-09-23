package com.miaosha.miaosha.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * Created by WangPeilei
 * Time 2018/9/23 10:16
 */
@Configuration
public class JedisPoolConfig {

    @Resource
    RedisConfig redisConfig;

    @Bean(name = "jedisPool")
    public JedisPool JedisFactory() {
        redis.clients.jedis.JedisPoolConfig poolConfig = new redis.clients.jedis.JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
        poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);
        return new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort(),
                redisConfig.getTimeout() * 1000, redisConfig.getPassword());
    }
}
