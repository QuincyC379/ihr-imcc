package com.zhaopin.dto;

import java.io.Serializable;

/**
 * 智联发送的消息
 * Created by SYJ on 2017/5/19.
 */
public class ZLMessageDto implements Serializable {

    /**
     * uuid用来保证当前消息的唯一性
     */
    private String unique;

    /**
     * 消息类型
     * 云信 0 表示文本消息,1 表示图片，2 表示语音，3 表示视频，4 表示地理位置信息，6 表示文件，100 自定义消息类型
     * 智联 1 文本消息，2 自定义消息
     */
    private int msgType;

    /**
     * 消息发送者userId
     */
    private long from;

    /**
     * 讨论组id
     */
    private long to;

    /**
     * 消息具体内容
     */
    private String message;
    /**
     * 设备ID
     */
    private String deviceId;
    /**
     * 设备类型
     */
    private int deviceType;
    /***
     * passportToken
     */
    private String token;

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ZLMessageDto{" +
                "unique='" + unique + '\'' +
                ", msgType=" + msgType +
                ", from=" + from +
                ", to=" + to +
                ", message='" + message + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceType=" + deviceType +
                ", token='" + token + '\'' +
                '}';
    }
}
