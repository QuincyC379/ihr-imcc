package com.zhaopin.core.common;

import com.zhaopin.enums.NeteaseStatusCode;

/**
 * Created by SYJ on 2017/5/19.
 */
public enum ViewHint {
    Success("成功", NeteaseStatusCode.Success.getValue()),
    Fail("失败", NeteaseStatusCode.Fail.getValue());

    private  String message;
    private  int code;

    ViewHint(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
