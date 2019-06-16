package com.sun.seckill.service.impl;

import com.sun.seckill.dao.taskOrderMapper;
import com.sun.seckill.model.taskOrder;
import com.sun.seckill.service.taskOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskOrderServiceImpl implements taskOrderService {
    @Autowired
    taskOrderMapper taskOrderMapper;

    @Override
    public int insert(taskOrder taskOrder) {
        return taskOrderMapper.insertSelective(taskOrder);
    }

    @Override
    public int update(taskOrder taskOrder) {
        return taskOrderMapper.updateByPrimaryKeySelective(taskOrder);
    }

    @Override
    public taskOrder select(Long id) {
        return taskOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return taskOrderMapper.deleteByPrimaryKey(id);
    }
}
