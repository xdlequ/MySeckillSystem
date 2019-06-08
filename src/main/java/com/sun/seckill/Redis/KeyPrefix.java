package com.sun.seckill.Redis;

/**
 * Created by ql on 2019/6/8.
 */
public interface KeyPrefix {
    int expireSeconds();
    String getPrefix();
}
