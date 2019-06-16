package com.sun.seckill.dao;

import com.sun.seckill.entity.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

    User selectByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);

    User checkPhone(@Param("phone") String phone);
}
