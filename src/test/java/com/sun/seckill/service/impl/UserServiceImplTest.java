package com.sun.seckill.service.impl;

import com.sun.seckill.SeckillApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SeckillApplication.class})
public class UserServiceImplTest {
    @Autowired
    UserMapper mapper;

    @Test
    public void insert() throws Exception {
        User user = new User();
        for (int i = 1; i <= 1000; i++) {
            Thread.sleep(1000);
            user.setUsername("username" + i);
            user.setPassword("password" + i);
            user.setRegisterDate(new Timestamp(System.currentTimeMillis()));
            user.setUpdateDate(new Timestamp(System.currentTimeMillis()));
            user.setAvatarUrl("avatarUrl" + i);
            user.setPhoneNum("13800138000");
            user.setEmail("username" + i + "@163.com");
            mapper.insertSelective(user);
        }
    }

    @Test
    public void update() {
    }

    @Test
    public void select() {
    }

    @Test
    public void delete() {
    }
}