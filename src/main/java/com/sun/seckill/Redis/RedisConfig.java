package com.sun.seckill.Redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by ql on 2019/6/8.
 */
@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {
    private String host;
    private int port;
    private int timeout;
    private String password;
    private int poolMaxTotal;//最大的连接数
    private int poolMaxIdle;//最大间隔
    private int poolMaxWait;//最大等待时间

}
