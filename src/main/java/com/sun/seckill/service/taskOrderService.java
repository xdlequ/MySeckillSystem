package com.sun.seckill.service;

import com.sun.seckill.model.taskOrder;

public interface taskOrderService extends BaseService<taskOrder> {
    taskOrder select(Long id);

    int delete(Long id);
}
