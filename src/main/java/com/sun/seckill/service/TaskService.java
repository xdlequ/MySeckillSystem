package com.sun.seckill.service;

import com.sun.seckill.model.Task;

public interface TaskService extends BaseService<Task> {
    Task select(Integer id);

    int delete(Integer id);
}
