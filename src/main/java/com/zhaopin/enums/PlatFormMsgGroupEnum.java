package com.zhaopin.enums;

/**
 * 平台消息分组
 * Created by SYJ on 2017/6/2.
 */
public enum PlatFormMsgGroupEnum {
    Discussion(2),Conversation(3),System(4),SingleChat(5);
    private Integer value;
    PlatFormMsgGroupEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
