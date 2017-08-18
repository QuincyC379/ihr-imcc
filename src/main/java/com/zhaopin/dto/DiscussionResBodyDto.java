package com.zhaopin.dto;

/**
 * 创建讨论组接口返回Dto中的body
 * Created by SYJ on 2017/5/31.
 */
public class DiscussionResBodyDto {
    private int code;
    private long discussionId;

    public DiscussionResBodyDto() {
    }

    public DiscussionResBodyDto(int code, long discussionId) {
        this.code = code;
        this.discussionId = discussionId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(long discussionId) {
        this.discussionId = discussionId;
    }

    @Override
    public String toString() {
        return "DiscussionResBodyDto{" +
                "code=" + code +
                ", discussionId=" + discussionId +
                '}';
    }
}
