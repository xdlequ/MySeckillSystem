package com.sun.seckill.controller;

import com.sun.seckill.model.User;
import com.sun.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        user.setRegisterDate(new Timestamp(System.currentTimeMillis()));
        user.setUpdateDate(new Timestamp(System.currentTimeMillis()));
        service.insert(user);
        return "add user success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User selectUser(@PathVariable Integer id) {
        User user = service.select(id);
        return user;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(@RequestBody User user) {
        user.setUpdateDate(new Timestamp(System.currentTimeMillis()));
        service.update(user);
        return "update user success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer id) {
        service.delete(id);
        return "delete user success";
    }
}