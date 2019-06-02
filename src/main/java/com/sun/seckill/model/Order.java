package com.sun.seckill.model;

import java.util.Date;

public class Order extends OrderKey {
    private Date createTime;

    public Order(Integer taskId, Integer userId) {
        super(taskId, userId);
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}