package com.sun.seckill.service;

import com.sun.seckill.model.taskGoods;

public interface taskGoodsService extends BaseService<taskGoods> {
    taskGoods select(Long id);

    int delete(Long id);
}
