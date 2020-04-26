package com.zj.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * TODO
 *
 * @author wansri
 * @data 2020/4/26 10:31 上午
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
