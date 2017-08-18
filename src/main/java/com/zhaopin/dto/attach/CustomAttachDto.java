package com.zhaopin.dto.attach;

/**
 * 自定义消息（msgType类型为CUSTOM）
 * 由第三方自己定义并解析相应的Key-Value值
 * Created by SYJ on 2017/5/18.
 */
public class CustomAttachDto<T> {

    private Integer type;//自定义消息类型
    private T data;//自定义消息体

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CustomAttachDto{" +
                "type=" + type +
                ", data=" + data +
                '}';
    }
}
