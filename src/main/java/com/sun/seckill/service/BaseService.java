package com.sun.seckill.service;

import java.util.List;

public interface BaseService<T> {
    //添加
    int insert(T t);

    //修改
    int update(T t);
}
