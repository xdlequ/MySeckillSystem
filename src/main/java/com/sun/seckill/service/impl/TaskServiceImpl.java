package com.sun.seckill.service.impl;

import com.sun.seckill.dao.TaskMapper;
import com.sun.seckill.model.Task;
import com.sun.seckill.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;

    @Override
    public int insert(Task task) {
        return taskMapper.insertSelective(task);
    }

    @Override
    public int update(Task task) {
        return taskMapper.updateByPrimaryKeySelective(task);
    }

    @Override
    public Task select(Integer id) {
        return taskMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Integer id) {
        return taskMapper.deleteByPrimaryKey(id);
    }
}
