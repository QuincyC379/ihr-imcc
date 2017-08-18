package com.zhaopin.enums;

/**
 * 云信抄送消息类型，目前包含6类
 * Created by SYJ on 2017/5/17.
 */
public enum NeteaseEventTypeEnum {
    /**
     * CONVERSATION:会话类型的消息
     * （目前包括P2P聊天消息，群组聊天消息，群组操作，好友操作）
     */
    CONVERSATION(1),
    /**
     * 表示LOGIN消息，即用户登录事件的消息
     */
    LOGIN(2),
    /**
     * 表示LOGOUT消息，即用户登出事件的消息
     */
    LOGOUT(3),
    /**
     * 表示CHATROOM消息，即聊天室中聊天的消息
     */
    CHATROOM(4);

    private Integer value;

    NeteaseEventTypeEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
