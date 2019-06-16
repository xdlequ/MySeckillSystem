package com.sun.seckill.controller;

import com.sun.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    /**
     * 增加用户，方法使用POST类型，通过访问/user 进行，在请求的body中添加json格式数据。<p/>
     * String username;用户名
     * String password;密码
     * String avatarUrl;用户头像地址
     * String phoneNum;电话号码
     * String email;电子邮箱地址
     * String location;送货地址
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        user.setRegisterDate(new Timestamp(System.currentTimeMillis()));
        user.setUpdateDate(new Timestamp(System.currentTimeMillis()));
        service.insert(user);
        return "add user success";
    }

    /**
     * 选取用户，方法使用GET类型，通过访问 /user/{id} 进行，根据主键进行查询，查询结果中返回为json格式数据。<p/>
     * Integer id;主键
     * String username;用户名
     * String password;密码
     * String avatarUrl;用户头像地址
     * String phoneNum;电话号码
     * String email;电子邮箱地址
     * String location;送货地址
     * Date registerDate;注册时间
     * Date updateDate;最后更新时间
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User selectUser(@PathVariable Integer id) {
        User user = service.select(id);
        return user;
    }

    /**
     * 修改用户信息，方法使用PUT类型，通过访问 /user 进行，根据主键进行修改，在请求的body中添加json格式数据。<br>
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(@RequestBody User user) {
        user.setUpdateDate(new Timestamp(System.currentTimeMillis()));
        service.update(user);
        return "update user success";
    }

    /**
     * 删除用户，方法使用DELETE类型，通过访问 /user/{id} 进行，根据主键进行删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer id) {
        service.delete(id);
        return "delete user success";
    }
}