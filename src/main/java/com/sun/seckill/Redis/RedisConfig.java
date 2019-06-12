package com.sun.seckill.Redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 *
 * @author ql
 * @date 2019/6/8
 */
@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {/**从配置文件中读取redis相关的配置*/
    private String host;
    private int port;
    private int timeout;
    private String password;
    /**最大的连接数*/
    private int poolMaxTotal;
    /**最大空闲间隔*/
    private int poolMaxIdle;
    /**最大等待时间*/
    private int poolMaxWait;

}
