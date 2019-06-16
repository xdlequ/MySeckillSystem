package com.sun.seckill.Utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ql on 2019/6/16.
 */

public class mobilevalidator {
    private static final Pattern mobile_pattern=Pattern.compile("1\\d{10}");
    /**
     * 判断是否是手机号
     * @param o
     * @return
     */
    public static boolean validator(String o) {
        /**
         * 判断是否为空
         */
        if (StringUtils.isEmpty(o)){
            return false;
        }
        /**
         * 判断是否匹配
         */
        Matcher matcher=mobile_pattern.matcher(o);
        //返回匹配结果
        return matcher.matches();
    }
}
