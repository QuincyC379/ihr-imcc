package com.zhaopin.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by SYJ on 2017/5/31.
 */
public class DiscussionRequestDto {
    @JSONField(name = "header")
    private HeaderDto headerDto;
    @JSONField(name = "body")
    private DiscussionBodyDto discussionBodyDto;
    @JSONField(name = "user")
    private UserDto userDto;

    public DiscussionRequestDto() {
    }

    public DiscussionRequestDto(HeaderDto headerDto, DiscussionBodyDto discussionBodyDto, UserDto userDto) {
        this.headerDto = headerDto;
        this.discussionBodyDto = discussionBodyDto;
        this.userDto = userDto;
    }

    public HeaderDto getHeaderDto() {
        return headerDto;
    }

    public void setHeaderDto(HeaderDto headerDto) {
        this.headerDto = headerDto;
    }

    public DiscussionBodyDto getDiscussionBodyDto() {
        return discussionBodyDto;
    }

    public void setDiscussionBodyDto(DiscussionBodyDto discussionBodyDto) {
        this.discussionBodyDto = discussionBodyDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public String toString() {
        return "DiscussionRequestDto{" +
                "headerDto=" + headerDto +
                ", discussionBodyDto=" + discussionBodyDto +
                ", userDto=" + userDto +
                '}';
    }
}
