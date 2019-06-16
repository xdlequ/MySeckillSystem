package com.sun.seckill.controller;

import com.sun.seckill.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class TaskController {
    @Autowired
    private TaskService service;

    /**
     * 增加秒杀任务，方法使用POST类型，通过访问/task 进行，在请求的body中添加json格式数据。<p/>
     * Integer goodsId; 对应的商品id<p/>
     * Integer count; 总商品数量<p/>
     * Integer countLeft; 剩余商品数量<p/>
     * Date startTime; 秒杀开始时间<p/>
     * private Date endTime; 秒杀结束时间<p/>
     *
     * @param task
     * @return
     */
    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public String addTask(@RequestBody Task task) {
        task.setCreateTime(new Timestamp(System.currentTimeMillis()));
        service.insert(task);
        return "add task success";
    }

    /**
     * 选取秒杀任务，方法使用GET类型，通过访问 /task/{id} 进行，根据主键进行查询，查询结果中返回为json格式数据。<p/>
     * 会关联查询到这个秒杀任务对应的商品信息<p/>
     * private Integer id;<p/>
     * Integer goodsId; 对应的商品id<p/>
     * Integer count; 总商品数量<p/>
     * Integer countLeft; 剩余商品数量<p/>
     * Date startTime; 秒杀开始时间<p/>
     * Date endTime; 秒杀结束时间<p/>
     * Date createTime;秒杀任务的创建时间<p/>
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    public Task selectTask(@PathVariable Integer id) {
        Task task = service.select(id);
        return task;
    }

    /**
     * 修改秒杀任务，方法使用PUT类型，通过访问 /task 进行，根据主键进行修改，在请求的body中添加json格式数据。<br>
     * @param task
     * @return
     */
    @RequestMapping(value = "/task", method = RequestMethod.PUT)
    public String updateTask(@RequestBody Task task) {
        service.update(task);
        return "update task success";
    }

    /**
     * 删除秒杀任务，方法使用DELETE类型，通过访问 /task/{id} 进行，根据主键进行删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
    public String deleteTask(@PathVariable Integer id) {
        service.delete(id);
        return "delete task success";
    }
}
