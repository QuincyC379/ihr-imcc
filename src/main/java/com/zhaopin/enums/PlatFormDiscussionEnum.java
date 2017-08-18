package com.zhaopin.enums;

/**
 * 讨论组类型
 * Created by SYJ on 2017/6/2.
 */
public enum PlatFormDiscussionEnum {

    SEND_MESSAGE(1),/** 发送消息 */
    GET_DISCUSSIONMEMBER(2),/** 获取讨论组成员 */
    GET_HISTORY_MESSAGE(3),/** 获取历史消息 */
    SEND_RECEIPT_MESSAGE(4),/** 设置已读 */
    CREATE_DISCUSSION(5),/** 创建讨论组 */
    ADD_DISCUSSIONMEMBER(6),/** 添加讨论组成员 */
    QUIT_DISCUSSION(7),/** 退出讨论组 */
    DISMISS_DISCUSSION(8),/** 解散讨论组 */
    OUT_ADDED_DISCUSSION(9),/** 被加入讨论组通知 */
    OUT_ADDTO_DISCUSSION(10),/** 新成员加入讨论组通知 */
    OUT_QUIT_DISCUSSION(11),/** 讨论组成员退出通知 */
    OUT_DISMISS_DISCUSSION(12);/** 讨论组解散通知 */

    private Integer value;
    PlatFormDiscussionEnum(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }
}
