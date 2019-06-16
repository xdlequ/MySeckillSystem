package com.sun.seckill.service.impl;

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
    public Order select(Integer taskId,Integer userId) {
        return orderMapper.selectByPrimaryKey(taskId, userId);
    }

    @Override
    public int delete(Integer taskId,Integer userId) {
        return orderMapper.deleteByPrimaryKey(taskId, userId);
    }
}
