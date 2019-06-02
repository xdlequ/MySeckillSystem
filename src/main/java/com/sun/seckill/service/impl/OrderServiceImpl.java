package com.sun.seckill.service.impl;

import com.sun.seckill.dao.OrderMapper;
import com.sun.seckill.model.Order;
import com.sun.seckill.model.OrderKey;
import com.sun.seckill.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public int insert(Order order) {
        return orderMapper.insertSelective(order);
    }

    @Override
    public int update(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public Order select(OrderKey key) {
        return orderMapper.selectByPrimaryKey(key);
    }

    @Override
    public int delete(OrderKey key) {
        return orderMapper.deleteByPrimaryKey(key);
    }
}
