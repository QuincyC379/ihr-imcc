package com.zhaopin.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by SYJ on 2017/5/17.
 */
public class ReceiveBodyDto {
    @JSONField(name = "message")
    private ReceiveBodyMessage receiveBodyMessage;
    /**
     * 200为正确返回，其他都是错误请求,
     * 客户端拿到结果应该先判断是否正确返回
     */
    private Integer code;

    public ReceiveBodyMessage getReceiveBodyMessage() {
        return receiveBodyMessage;
    }

    public void setReceiveBodyMessage(ReceiveBodyMessage receiveBodyMessage) {
        this.receiveBodyMessage = receiveBodyMessage;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ReceiveBodyDto{" +
                "receiveBodyMessage=" + receiveBodyMessage +
                ", code=" + code +
                '}';
    }
}
