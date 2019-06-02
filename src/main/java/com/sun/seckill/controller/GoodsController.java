package com.sun.seckill.controller;

import com.sun.seckill.model.Goods;
import com.sun.seckill.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService service;

    @RequestMapping(value = "/goods", method = RequestMethod.POST)
    public String addGoods(@RequestBody Goods goods) {
        goods.setCreateTime(new Timestamp(System.currentTimeMillis()));
        goods.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        service.insert(goods);
        return "add goods success";
    }

    @RequestMapping(value = "/goods/{id}", method = RequestMethod.GET)
    public Goods selectGoods(@PathVariable Integer id) {
        Goods goods = service.select(id);
        return goods;
    }

    @RequestMapping(value = "/goods", method = RequestMethod.PUT)
    public String updateGoods(@RequestBody Goods goods) {
        goods.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        service.update(goods);
        return "update goods success";
    }

    @RequestMapping(value = "/goods/{id}", method = RequestMethod.DELETE)
    public String deleteGoods(@PathVariable Integer id) {
        service.delete(id);
        return "delete goods success";
    }
}
