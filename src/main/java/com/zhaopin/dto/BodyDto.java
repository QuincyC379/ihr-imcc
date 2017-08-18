package com.zhaopin.dto;

import java.util.Date;

/**
 * Created by SYJ on 2017/5/17.
 */
public class BodyDto {
    private Long from;//消息发送者userId
    private Long to;//讨论组id
    private Integer conversationType;//1代表讨论组
    private Integer msgType;//消息类型，文本消息1，自定义消息2
    private String message;//消息具体内容
    private Date sendTime;//发送时间，客户端生成

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public Integer getConversationType() {
        return conversationType;
    }

    public void setConversationType(Integer conversationType) {
        this.conversationType = conversationType;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "BodyDto{" +
                "from=" + from +
                ", to=" + to +
                ", conversationType=" + conversationType +
                ", msgType=" + msgType +
                ", message='" + message + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
