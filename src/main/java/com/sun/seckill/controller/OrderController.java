package com.sun.seckill.controller;

import com.sun.seckill.model.Order;
import com.sun.seckill.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class OrderController {
    @Autowired
    private OrderService service;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String addOrder(@RequestBody Order order) {
        order.setCreateTime(new Timestamp(System.currentTimeMillis()));
        service.insert(order);
        return "add order success";
    }

    @RequestMapping(value = "/order/{taskId}/{userId}", method = RequestMethod.GET)
    public Order selectOrder(@PathVariable Integer taskId,@PathVariable Integer userId) {
        Order order = service.select(taskId, userId);
        return order;
    }

    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public String updateOrder(@RequestBody Order order) {
        service.update(order);
        return "update order success";
    }

    @RequestMapping(value = "/order/{taskId}/{userId}", method = RequestMethod.DELETE)
    public String deleteOrder(@PathVariable Integer taskId,@PathVariable Integer userId) {
        service.delete(taskId, userId);
        return "delete order success";
    }
}
