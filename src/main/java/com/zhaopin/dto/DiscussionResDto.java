package com.zhaopin.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 创建讨论组接口返回Dto
 * Created by SYJ on 2017/6/1.
 */
public class DiscussionResDto {
    @JSONField(name = "header")
    private HeaderDto headerDto;
    /*@JSONField(name = "body")
    private DiscussionResBodyDto discussionResBodyDto;*/
    private String body;
    @JSONField(name = "user")
    private DiscussionResUserDto discussionResUserDto;

    public DiscussionResDto() {
    }

    public DiscussionResDto(HeaderDto headerDto, String body, DiscussionResUserDto discussionResUserDto) {
        this.headerDto = headerDto;
        this.body = body;
        this.discussionResUserDto = discussionResUserDto;
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

    public DiscussionResUserDto getDiscussionResUserDto() {
        return discussionResUserDto;
    }

    public void setDiscussionResUserDto(DiscussionResUserDto discussionResUserDto) {
        this.discussionResUserDto = discussionResUserDto;
    }

    @Override
    public String toString() {
        return "DiscussionResDto{" +
                "headerDto=" + headerDto +
                ", body='" + body + '\'' +
                ", discussionResUserDto=" + discussionResUserDto +
                '}';
    }
}
