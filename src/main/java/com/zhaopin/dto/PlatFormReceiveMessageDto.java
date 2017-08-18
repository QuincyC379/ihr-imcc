package com.zhaopin.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 平台发送消息接口返回的数据格式
 * Created by SYJ on 2017/5/19.
 */
public class PlatFormReceiveMessageDto {

    @JSONField(name = "user")
    private UserDto userDto;
    @JSONField(name = "header")
    private HeaderDto headerDto;
    private String body;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public HeaderDto getHeaderDto() {
        return headerDto;
    }

    public void setHeaderDto(HeaderDto headerDto) {
        this.headerDto = headerDto;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "PlatFormReceiveMessageDto{" +
                "userDto=" + userDto +
                ", headerDto=" + headerDto +
                ", body='" + body + '\'' +
                '}';
    }
}
