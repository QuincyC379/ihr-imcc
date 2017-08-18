package com.zhaopin.enums;

/**
 * 自定义消息类型
 * Created by SYJ on 2017/5/18.
 */
public enum CustomAttachTypeEnum {

    ScissorsRockPaper(1),/** 剪刀 石头 布 */
    BurnAfterRead(2),/** 阅后即焚 */
    Chartlet(3),/** 贴图表情 */
    Flag(4);/** 白板会话 */

    private Integer value;

    CustomAttachTypeEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
