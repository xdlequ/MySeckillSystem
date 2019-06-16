package com.sun.seckill.Exception;

import com.sun.seckill.Enum.CodeMsg;

import java.io.Serializable;

/**
 * Created by ql on 2019/6/16.
 */

public class GlobalException extends RuntimeException implements Serializable{
    public static final long serialVersionUID=1L;
    private CodeMsg cm;
    public GlobalException(CodeMsg cm){
        super(cm.toString());
        this.cm=cm;
    }
    
}
