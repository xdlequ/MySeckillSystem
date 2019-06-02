package com.sun.seckill.service;

import com.sun.seckill.model.Goods;

public interface GoodsService extends BaseService<Goods> {
    Goods select(Integer id);

    int delete(Integer id);
}
