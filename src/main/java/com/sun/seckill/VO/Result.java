package com.sun.seckill.VO;

import com.sun.seckill.Enum.CodeMsg;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by ql on 2019/6/16.
 */
@Setter
@Getter
public class Result<T>{
    private int code;
    private String msg;
    private T value;
    private Result(T data){
        this.value=data;
    }
    private Result(int code,String msg){
        this.code=code;
        this.msg=msg;
    }
    public Result(CodeMsg codeMsg){
        if (codeMsg!=null){
            this.code=codeMsg.getCode();
            this.msg=codeMsg.getMessage();
        }
    }
    public static <T>Result<T> success(T data){
        return new Result<T>(data);
    }

    public static <T>Result<T>error(int code,String msg){
        return new Result<T>(code,msg);
    }
}
