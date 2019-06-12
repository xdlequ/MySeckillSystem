package com.sun.seckill.Redis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by ql on 2019/6/8.
 */
@Setter
@Getter
@AllArgsConstructor
public class BasePrefix implements KeyPrefix {
    /*过期时间*/
    private int expireSeconds;
    /*前缀名*/
    private String prefix;
    public BasePrefix(String prefix){
        this.prefix=prefix;
    }
    @Override
    public int expireSeconds() {
        return this.expireSeconds;
    }

    @Override
    public String getPrefix() {//redis KEY设计的核心所在，通过类名+前缀名增加区分度
        String className=this.getClass().getName();
        return className+":"+this.prefix;
    }
}
