package com.zhaopin.enums;

/**
 * 平台消息类型:
 *  1 文本消息
 *  2 自定义消息
 * Created by SYJ on 2017/5/18.
 */
public enum PlatFormMsgTypeEnum {
    // TODO 图片消息???
    TEXT(1),/** 文本消息 */
    CUSTOM(2);/** 自定义消息 */

    private Integer value;

    PlatFormMsgTypeEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
