package com.zhaopin.dto;

import java.util.List;

/**
 * Created by SYJ on 2017/5/31.
 */
public class DiscussionBodyDto {
    private Integer eventType;
    private Integer eventId;
    private String title;
    private List<Long> userIdList;

    public DiscussionBodyDto() {
    }

    public DiscussionBodyDto(Integer eventType, Integer eventId, String title, List<Long> userIdList) {
        this.eventType = eventType;
        this.eventId = eventId;
        this.title = title;
        this.userIdList = userIdList;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Long> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<Long> userIdList) {
        this.userIdList = userIdList;
    }

    @Override
    public String toString() {
        return "DiscussionBodyDto{" +
                "eventType=" + eventType +
                ", eventId=" + eventId +
                ", title='" + title + '\'' +
                ", userIdList=" + userIdList +
                '}';
    }
}
