package com.sun.seckill.Utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;



/**
 * Created by ql on 2019/6/16.
 */


public class MD5Utils {

    public static String md5(String str){
        return DigestUtils.md5Hex(str);
    }
    public static String FromPassToDB(String password, String salt) {
        String str=""+salt.charAt(0)+salt.charAt(2) + password +salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }
}
