package com.zhaopin.enums;

/**
 * 平台单聊
 * Created by SYJ on 2017/6/2.
 */
public enum PlatFormSingleChatEnum {
    SEND_MESSAGE(1),/** 发送消息 */
    SET_BLACKLIST(2),/** 设置黑名单状态 */
    GET_HISTORY_MESSAGE(3),/** 获取历史消息 */
    SEND_RECEIPT_MESSAGE(4),/** 设置已读 */
    GET_BLACKLIST(5);/** 获取黑名单 */

    private Integer value;
    PlatFormSingleChatEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
