package com.zhaopin.dto;

/**
 * 创建讨论组接口返回Dto中的user
 * Created by SYJ on 2017/6/1.
 */
public class DiscussionResUserDto {
    private long updateTime;
    private String sessionId;
    private String token;
    private String deviceType;
    private String userId;
    private String deviceId;
    private Boolean online;
    private String serviceName;

    public DiscussionResUserDto() {
    }

    public DiscussionResUserDto(long updateTime, String sessionId, String token, String deviceType, String userId, String deviceId, Boolean online, String serviceName) {
        this.updateTime = updateTime;
        this.sessionId = sessionId;
        this.token = token;
        this.deviceType = deviceType;
        this.userId = userId;
        this.deviceId = deviceId;
        this.online = online;
        this.serviceName = serviceName;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "DiscussionResUserDto{" +
                "updateTime=" + updateTime +
                ", sessionId='" + sessionId + '\'' +
                ", token='" + token + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", userId='" + userId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", online=" + online +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
