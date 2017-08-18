package com.zhaopin.dto;

/**
 * Created by SYJ on 2017/5/18.
 */
public class UserDto {

    private String userId;//用户ID
    private String deviceId;//设备ID
    private Integer deviceType;//设备类型
    private String token;//passportToken

    public UserDto() {
    }

    public UserDto(String userId, String deviceId, Integer deviceType, String token) {
        this.userId = userId;
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.token = token;
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

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
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
        return "UserDto{" +
                "userId='" + userId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceType=" + deviceType +
                ", token='" + token + '\'' +
                '}';
    }
}
