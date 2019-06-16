package com.sun.seckill.VO;

import com.sun.seckill.Annotation.IsMobile;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by ql on 2019/6/16.
 */
@Getter
@Setter
public class loginVo {
    @NotNull
    @IsMobile
    private Integer phoneNum;


    @NotNull
    @Length(min=8)
    private String password;
    @Override
    public String toString() {
        return "loginInfo{" +
                "phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
