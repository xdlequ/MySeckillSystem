package com.sun.seckill.service;

import com.sun.seckill.model.Order;

public interface OrderService extends BaseService<Order> {
    Order select(Integer taskId,Integer userId);

    int delete(Integer taskId,Integer userId);
}
