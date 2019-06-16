package com.sun.seckill.service;

import com.sun.seckill.model.User;

public interface UserService extends BaseService<User> {
    User select(Integer id);
    int delete(Integer id);
}
