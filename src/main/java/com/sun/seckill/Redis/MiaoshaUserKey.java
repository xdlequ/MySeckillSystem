package com.sun.seckill.Redis;

/**
 * Created by ql on 2019/6/16.
 */
public class MiaoshaUserKey extends BasePrefix{
    public static final int EXPIRE_TIME=3600*24*60;
    public MiaoshaUserKey(String prefix){
        super(prefix);
    }
    public MiaoshaUserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
    public static MiaoshaUserKey token=new MiaoshaUserKey(EXPIRE_TIME,"tk");
    public static MiaoshaUserKey userKey=new MiaoshaUserKey("user");
    // public static final String
}
