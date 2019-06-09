package com.sun.seckill.Redis;

/**
 * Created by ql on 2019/6/8.
 */
public interface KeyPrefix {//前缀接口
    int expireSeconds();
    String getPrefix();
}
