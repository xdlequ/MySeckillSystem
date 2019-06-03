package com.sun.seckill.service.impl;

import com.sun.seckill.SeckillApplication;
import com.sun.seckill.dao.GoodsMapper;
import com.sun.seckill.dao.UserMapper;
import com.sun.seckill.model.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SeckillApplication.class})
public class GoodsServiceImplTest {
    @Autowired
    GoodsMapper mapper;
    @Test
    public void insert() throws Exception{
        Goods goods=new Goods();
        for (int i = 1; i <=20; i++) {
            Thread.sleep(1000);
            goods.setGoodName("goodName"+i);
            goods.setPrice(new BigDecimal(20));
            goods.setCreateTime(new Timestamp(System.currentTimeMillis()));
            goods.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            mapper.insertSelective(goods);
        }

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