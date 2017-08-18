package com.zhaopin.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by SYJ on 2017/5/17.
 */
public class SendMessageDto {
    @JSONField(name = "header")
    private HeaderDto headerDto;
    @JSONField(name = "body")
    private BodyDto bodyDto;
    @JSONField(name = "user")
    private UserDto userDto;

    public SendMessageDto() {
    }

    public SendMessageDto(HeaderDto headerDto, BodyDto bodyDto, UserDto userDto) {
        this.headerDto = headerDto;
        this.bodyDto = bodyDto;
        this.userDto = userDto;
    }

    public HeaderDto getHeaderDto() {
        return headerDto;
    }

    public void setHeaderDto(HeaderDto headerDto) {
        this.headerDto = headerDto;
    }

    public BodyDto getBodyDto() {
        return bodyDto;
    }

    public void setBodyDto(BodyDto bodyDto) {
        this.bodyDto = bodyDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public String toString() {
        return "SendMessageDto{" +
                "headerDto=" + headerDto +
                ", bodyDto=" + bodyDto +
                ", userDto=" + userDto +
                '}';
    }
}
