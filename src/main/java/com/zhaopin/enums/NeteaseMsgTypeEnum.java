package com.zhaopin.enums;

/**
 * Created by SYJ on 2017/5/17.
 */
public enum NeteaseMsgTypeEnum {
    /**
     * 会话具体类型PERSON、TEAM对应的通知消息类型
     */
    TEXT(1),/** 文本消息 */
    PICTURE(2),/** 图片消息 */
    AUDIO(3),/** 音频消息 */
    VIDEO(4),/** 视频消息 */
    LOCATION(5),/** 地理位置消息 */
    NOTIFICATION(6),/** 讨论组或群操作事件 */
    FILE(7),/** 文件消息 */
    NETCALL_AUDIO(8),/** 网络电话音频聊天 */
    NETCALL_VEDIO(9),/** 网络电话视频聊天 */
    DATATUNNEL_NEW(10),/** 新的数据通道请求通知 */
    TIPS(11),/** 提醒类型消息 */
    CUSTOM(12),/** 自定义消息 */

    /**
     * 会话具体类型CUSTOM_PERSON对应的通知消息类型
     */
    FRIEND_ADD(13),/** 加好友 */
    FRIEND_DELETE(14),/** 删除好友 */
    CUSTOM_P2P_MSG(15),/** 个人自定义系统通知 */

    /**
     * 会话具体类型CUSTOM_TEAM对应的通知消息类型
     */
    TEAM_APPLY(16),/** 申请入群 */
    TEAM_APPLY_REJECT(17),/** 拒绝入群申请 */
    TEAM_INVITE(18),/** 邀请进群 */
    TEAM_INVITE_REJECT(19),/** 拒绝邀请 */
    TLIST_UPDATE(20),/** 群信息更新 */
    CUSTOM_TEAM_MSG(21);/** 群组自定义系统通知 */

    NeteaseMsgTypeEnum(Integer value){
        this.value = value;
    }
    private Integer value;

    public Integer getValue() {
        return value;
    }
}
