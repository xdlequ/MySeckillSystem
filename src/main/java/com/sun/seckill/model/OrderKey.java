package com.sun.seckill.model;

import java.io.Serializable;

public class OrderKey implements Serializable {
    private Integer taskId;

    private Integer userId;

    public OrderKey(Integer taskId, Integer userId) {
        this.taskId = taskId;
        this.userId = userId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}