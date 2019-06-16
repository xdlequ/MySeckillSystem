package com.sun.seckill.service.impl;

import com.sun.seckill.Enum.CodeMsg;
import com.sun.seckill.Exception.GlobalException;
import com.sun.seckill.Redis.MiaoshaUserKey;
import com.sun.seckill.Redis.RedisService;
import com.sun.seckill.Utils.MD5Utils;
import com.sun.seckill.VO.loginVo;
import com.sun.seckill.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    RedisService redisService;

    private static final String COOKIE_TOKEN="tk";
    @Override
    public int insert(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User select(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
    @Override
    public int delete(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }


    public boolean login(HttpServletResponse response, @Valid loginVo loginVo) {
        if (loginVo==null){
            //服务器异常
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        log.info(loginVo.toString());
        Integer phoneNum=loginVo.getPhoneNum();
        String password=loginVo.getPassword();
        User user=select(phoneNum);
        if (user==null){
            //用户不存在
            throw new GlobalException(CodeMsg.USER_NOT_EXIST);
        }
        String dbsalt=user.getSalt();
        String dbpass=user.getPassword();
        //需要将pass进行转化成数据库中存储的状态进而进行验证。
        String passvalid= MD5Utils.FromPassToDB(password,dbsalt);
        if (!passvalid.equals(dbpass)){
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        redisService.set(MiaoshaUserKey.userKey,user.getUsername(),user);
        String token= UUID.randomUUID().toString();
        //将相应的token加入到response中返还给用户。
        addToken(response,token);
        return true;
    }

    /**
     * 向response报文中添加生成好的token
     * @param response
     * @param token
     */
    public void addToken(HttpServletResponse response,String token){
        Cookie cookie=new Cookie(COOKIE_TOKEN,token);
        cookie.setPath("/");
        /**设置过期时间**/
        cookie.setMaxAge(MiaoshaUserKey.token.getExpireSeconds());
        response.addCookie(cookie);
    }
}
