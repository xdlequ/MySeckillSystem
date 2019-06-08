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
    private int expireSeconds;
    private String prefix;
    public BasePrefix(String prefix){
        this.prefix=prefix;
    }
    @Override
    public int expireSeconds() {
        return this.expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className=this.getClass().getName();
        return className+":"+this.prefix;
    }
}
