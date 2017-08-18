package com.zhaopin.dto;

import java.util.Date;

/**
 * Created by SYJ on 2017/5/17.
 */
public class ReceiveBodyMessage {
    private Integer messageId;//服务器生成messageId
    private Date createTime;//服务器入库时间

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ReceiveBodyMessage{" +
                "messageId=" + messageId +
                ", createTime=" + createTime +
                '}';
    }
}
