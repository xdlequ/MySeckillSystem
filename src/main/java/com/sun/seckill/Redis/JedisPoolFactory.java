package com.sun.seckill.Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by ql on 2019/6/8.
 */
@Service
public class JedisPoolFactory {
    @Autowired
    RedisConfig redisConfig;
    @Bean
    public JedisPool jedisPoolFactory(){
        JedisPoolConfig poolConfig=new JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
        poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait());
        JedisPool jedisPool=new JedisPool(poolConfig,
                redisConfig.getHost(),redisConfig.getPort(),redisConfig.getTimeout(),redisConfig.getPassword());
        return jedisPool;
    }
}
