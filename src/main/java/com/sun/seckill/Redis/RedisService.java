package com.sun.seckill.Redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by ql on 2019/6/8.
 */
@Service
public class RedisService {
    @Autowired
    JedisPool jedisPool;

    public <T>boolean set(KeyPrefix prefix,String key,T value){
        Jedis jedis=null;

        try {
            jedis=jedisPool.getResource();
            if (key==null||key.length()==0){
                return false;
            }
            String reallyKey=prefix.getPrefix()+key;
            String str=beanTostring(value);
            jedis.set(reallyKey,str);
            return true;
        } finally {
            returnJedis(jedis);
        }

    }
    public <T> T get(KeyPrefix prefix,String key,Class<T>clazz){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            if (key==null||key.length()==0){
                return null;
            }
            String reallyKey=prefix.getPrefix()+key;
            //String str=beanTostring(value);
            String str=jedis.get(reallyKey);
            Object obj=stringTobean(str,clazz);
            return (T) obj;
        } finally {
            returnJedis(jedis);
        }
    }
    public static <T> String beanTostring(T value) {
        if (value==null){
            return null;
        }
        Class<?>clazz=value.getClass();
        if (clazz==int.class||clazz==Integer.class){
            return ""+value;
        }else if (clazz==String.class){
            return (String)value;
        }else if (clazz==long.class||clazz==Long.class){
            return ""+value;
        }else return JSON.toJSONString(value);
    }
    public static <T> T stringTobean(String str,Class<T>clazz) {
        if (str==null||str.length()==0){
            return null;
        }
        if (clazz==int.class||clazz==Integer.class){
            return (T)Integer.valueOf(str);
        }else if (clazz==long.class||clazz==Long.class){
            return (T)Long.valueOf(str);
        }else if (clazz==String.class){
            return (T)str;
        }else {
            return JSON.toJavaObject(JSON.parseObject(str),clazz);
        }
    }
    public void returnJedis(Jedis jedis){
        if (jedis!=null){
            jedis.close();
        }
    }
    public <T> Long incr(KeyPrefix prefix,String key){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            String realKey=prefix.getPrefix()+key;
            return jedis.incr(realKey);
        } finally {
            returnJedis(jedis);
        }
    }

    public <T> Long decr(KeyPrefix prefix,String key){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            String realKey=prefix.getPrefix()+key;
            return jedis.decr(realKey);
        } finally {
            returnJedis(jedis);
        }
    }

    public boolean delete(KeyPrefix prefix,String key){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            String realKey=prefix.getPrefix()+key;
            long ret=jedis.del(realKey);
            return ret>0;
        } finally {
            returnJedis(jedis);
        }
    }
}
