package com.sun.seckill.controller;

import com.sun.seckill.model.Task;
import com.sun.seckill.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class TaskController {
    @Autowired
    private TaskService service;

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public String addTask(@RequestBody Task task) {
        task.setCreateTime(new Timestamp(System.currentTimeMillis()));
        service.insert(task);
        return "add task success";
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    public Task selectTask(@PathVariable Integer id) {
        Task task = service.select(id);
        return task;
    }

    @RequestMapping(value = "/task", method = RequestMethod.PUT)
    public String updateTask(@RequestBody Task task) {
        service.update(task);
        return "update task success";
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
    public String deleteTask(@PathVariable Integer id) {
        service.delete(id);
        return "delete task success";
    }
}
