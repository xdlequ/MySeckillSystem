package com.sun.seckill.service.impl;

import com.sun.seckill.dao.UserMapper;
import com.sun.seckill.service.BaseService;
import com.sun.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    @Override
    public List findAll() {
        return mapper.findAll();
    }

    /*@Override
    public List findById(Long id) {
        return null;
    }

    @Override
    public void create(Object o) {

    }

    @Override
    public void delete(Long... ids) {

    }

    @Override
    public void update(Object o) {

    }*/
}
