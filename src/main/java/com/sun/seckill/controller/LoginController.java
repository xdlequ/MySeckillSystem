package com.sun.seckill.controller;

import com.sun.seckill.Redis.RedisService;
import com.sun.seckill.VO.loginVo;
import com.sun.seckill.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    RedisService redisService;

    /**
     * 登录
     * @param response
     * @param loginVo
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String dologin(HttpServletResponse response, loginVo loginVo) {
        log.info(loginVo.toString());
        boolean result=userServiceImpl.login(response,loginVo);
        log.info("login result"+result);
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String tologin(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.DELETE)
    public void logout(){
    }
}