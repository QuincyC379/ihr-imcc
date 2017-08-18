package com.zhaopin.enums;

/**
 * 返回给云信的状态码
 * Created by SYJ on 2017/5/18.
 */
public enum NeteaseStatusCode {
    /**
     * 成功
     */
    Success(200),
    /**
     * 失败
     */
    Fail(414);

    private Integer value;
    NeteaseStatusCode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
