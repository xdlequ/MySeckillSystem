package com.sun.seckill.service.impl;

import com.sun.seckill.SeckillApplication;
import com.sun.seckill.dao.OrderMapper;
import com.sun.seckill.model.Order;
import com.sun.seckill.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SeckillApplication.class})
public class OrderServiceImplTest {
    @Autowired
    OrderMapper mapper;

    @Test
    public void insert() {
        Order order = new Order();
        order.setTaskId(1);
        order.setUserId(1);
        order.setCreateTime(new Timestamp(System.currentTimeMillis()));
//        mapper.insert(order);
        mapper.insertSelective(order);
    }

    @Test
    public void update() {
    }

    @Test
    public void select() {
    }

    @Test
    public void delete() {
    }
}