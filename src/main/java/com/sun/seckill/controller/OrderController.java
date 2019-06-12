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

    /**
     * 增加订单，方法使用POST类型，通过访问/order 进行，在请求的body中添加json格式数据。<p/>
     * Integer taskId; 秒杀任务id<p/>
     * Integer userId; 用户id<p/>
     *
     * @param order
     * @return
     */
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String addOrder(@RequestBody Order order) {
        order.setCreateTime(new Timestamp(System.currentTimeMillis()));
        service.insert(order);
        return "add order success";
    }

    /**
     * 选取订单，方法使用GET类型，通过访问 /order/{taskId}/{userId} 进行，根据主键进行查询，查询结果中返回为json格式数据。<p/>
     * 做了关联查询，除了订单信息外，还根据taskId和userId返回关联的秒杀任务和购买商品的客户
     * Integer taskId; 秒杀任务id<p/>
     * Integer userId; 用户id<p/>
     * Task task; 关联的秒杀任务<p/>
     * User user; 关联的购买用户信息<<p/>
     *
     * @param taskId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/order/{taskId}/{userId}", method = RequestMethod.GET)
    public Order selectOrder(@PathVariable Integer taskId, @PathVariable Integer userId) {
        Order order = service.select(taskId, userId);
        return order;
    }

    /**
     * 修改订单，方法使用PUT类型，通过访问 /order 进行，根据主键进行修改，在请求的body中添加json格式数据。<br>
     * 这个基本用不到，因为除了主键之外没有其他属性了
     *
     * @param order
     * @return
     */
    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public String updateOrder(@RequestBody Order order) {
        service.update(order);
        return "update order success";
    }

    /**
     * 删除订单，方法使用DELETE类型，通过访问 /order/{taskId}/{userId} 进行，根据主键进行删除
     *
     * @param taskId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/order/{taskId}/{userId}", method = RequestMethod.DELETE)
    public String deleteOrder(@PathVariable Integer taskId, @PathVariable Integer userId) {
        service.delete(taskId, userId);
        return "delete order success";
    }
}
