package com.sun.seckill.Enum;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by ql on 2019/6/16.
 */
@Setter
@Getter
public class CodeMsg {
    private int code;
    private String message;
    /**通用问题**/
    public static CodeMsg SUCCESS=new CodeMsg(0,"登录成功");
    public static CodeMsg SERVER_ERROR=new CodeMsg(50100,"服务器异常");
    public static CodeMsg BIND_ERROR=new CodeMsg(50101,"参数异常");
    public static CodeMsg REQUEST_ILLEGAL=new CodeMsg(50102,"请求非法");
    public static CodeMsg ACCESS_LIMIT_REACHED=new CodeMsg(50104,"访问太频繁");
    /**登录方面的问题**/
    //public static CodeMsg USERNAME_ERROR=new CodeMsg(500200,"用户名");
    public static CodeMsg PASSWORD_ERROR=new CodeMsg(500201,"密码错误");
    public static CodeMsg USER_NOT_EXIST=new CodeMsg(500202,"用户不存在");

    public CodeMsg(int code,String message) {
        this.code=code;
        this.message=message;
    }

}
