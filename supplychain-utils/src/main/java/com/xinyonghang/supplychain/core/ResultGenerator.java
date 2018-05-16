package com.xinyonghang.supplychain.core;

/**
 * 响应结果生成工具
 *
 * @author chengjiawei
 * @date 2018年3月30日
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(Integer code, String message) {
        return new Result()
                .setCode(code)
                .setMessage(message);
    }
}
