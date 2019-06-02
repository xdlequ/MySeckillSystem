package com.sun.seckill.service;

import com.sun.seckill.model.Order;
import com.sun.seckill.model.OrderKey;

public interface OrderService extends BaseService<Order> {
    Order select(OrderKey key);

    int delete(OrderKey key);
}
