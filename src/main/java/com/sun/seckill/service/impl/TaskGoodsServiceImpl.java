package com.sun.seckill.service.impl;

import com.sun.seckill.dao.taskGoodsMapper;
import com.sun.seckill.model.taskGoods;
import com.sun.seckill.service.taskGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskGoodsServiceImpl implements taskGoodsService {
    @Autowired
    taskGoodsMapper taskGoodsMapper;

    @Override
    public int insert(taskGoods taskGoods) {
        return taskGoodsMapper.insertSelective(taskGoods);
    }

    @Override
    public int update(taskGoods taskGoods) {
        return taskGoodsMapper.updateByPrimaryKeySelective(taskGoods);
    }

    @Override
    public taskGoods select(Long id) {
        return taskGoodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return taskGoodsMapper.deleteByPrimaryKey(id);
    }
}
