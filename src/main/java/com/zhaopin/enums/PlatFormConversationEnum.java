package com.zhaopin.enums;

/**
 * 平台会话
 * Created by SYJ on 2017/6/2.
 */
public enum  PlatFormConversationEnum {
    GET_UNREADALL_COUNT(1),
    QUERY_RECENTLY_CONVERSATION(2),
    GET_UNREAD_COUNT(4),
    CLEAR_MESSAGE_UNREAD_STATUS(6);

    private Integer value;

    PlatFormConversationEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
