package com.zhaopin.dto;

/**
 * Created by SYJ on 2017/5/17.
 */
public class HeaderDto {
    private Integer version;//版本号，当前版本为1
    private Integer type;//客户端请求服务器
    private Integer group;//讨论组相关
    private Integer signall;//发送消息
    private String unique;//uuid用来保证当前消息的唯一性

    public HeaderDto() {}

    public HeaderDto(Integer version, Integer type, Integer group, Integer signall, String unique) {
        this.version = version;
        this.type = type;
        this.group = group;
        this.signall = signall;
        this.unique = unique;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Integer getSignall() {
        return signall;
    }

    public void setSignall(Integer signall) {
        this.signall = signall;
    }

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }

    @Override
    public String toString() {
        return "HeaderDto{" +
                "version=" + version +
                ", type=" + type +
                ", group=" + group +
                ", signall=" + signall +
                ", unique='" + unique + '\'' +
                '}';
    }
}
