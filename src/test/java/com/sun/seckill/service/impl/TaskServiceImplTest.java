package com.sun.seckill.service.impl;

import com.sun.seckill.SeckillApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SeckillApplication.class})
public class TaskServiceImplTest {
    @Autowired
    TaskMapper mapper;
    @Test
    public void insert() {
       HashMap Map=new HashMap();
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