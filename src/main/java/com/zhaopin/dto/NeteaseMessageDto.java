package com.zhaopin.dto;

import java.io.Serializable;

/**
 * 云信抄送消息
 * 会话类型消息中，并不是每个字段都会一定抄送，请注意对各字段的判空处理。
 * 以下为一般情况下必有的字段：
 * eventType,
 * convType,
 * to,
 * fromAccount,
 * msgTimestamp,
 * msgType,
 * msgidClient,
 * msgidServer.
 *
 * Created by SYJ on 2017/4/14.
 */
public class NeteaseMessageDto implements Serializable{

    private Integer id;
    private String attach;//附加消息，字符串类型
    private String body;//消息内容，字符串类型
    /**
     * 会话具体类型：
     * PERSON（二人会话数据）、TEAM（群聊数据）、
     * CUSTOM_PERSON（个人自定义系统通知）、
     * CUSTOM_TEAM（群组自定义系统通知），
     * 字符串类型
     */
    private String convType;
    /**
     * 抄送消息类型,
     * 目前包含6类(1表示会话类型消息,包括p2p聊天消息,群组聊天消息,群组操作和好友操作)
     */
    private String eventType;
    /**
     * 消息发送者的用户账号，字符串类型
     */
    private String fromAccount;
    /**
     * 发送客户端类型： AOS、IOS、PC、WINPHONE、WEB、REST，字符串类型
     */
    private String fromClientType;
    /**
     * 发送设备id，字符串类型
     */
    private String fromDeviceId;
    /**
     * 发送方昵称，字符串类型
     */
    private String fromNick;
    /**
     * 消息发送时间，字符串类型
     */
    private String msgTimestamp;
    /**
     * 会话具体类型PERSON、TEAM对应的通知消息类型：
     * TEXT、
     * PICTURE、
     * AUDIO、
     * VIDEO、
     * LOCATION 、
     * NOTIFICATION、
     * FILE、 //文件消息
     * NETCALL_AUDIO、 //网络电话音频聊天
     * NETCALL_VEDIO、 //网络电话视频聊天
     * DATATUNNEL_NEW、 //新的数据通道请求通知
     * TIPS、 //提醒类型消息
     * CUSTOM //自定义消息

     * 会话具体类型CUSTOM_PERSON对应的通知消息类型：
     * FRIEND_ADD、 //加好友
     * FRIEND_DELETE、 //删除好友
     * CUSTOM_P2P_MSG、 //个人自定义系统通知

     * 会话具体类型CUSTOM_TEAM对应的通知消息类型：
     * TEAM_APPLY、 //申请入群
     * TEAM_APPLY_REJECT、 //拒绝入群申请
     * TEAM_INVITE、 //邀请进群
     * TEAM_INVITE_REJECT、 //拒绝邀请
     * TLIST_UPDATE、 //群信息更新
     * CUSTOM_TEAM_MSG、 //群组自定义系统通知
     */
    private String msgType;
    /**
     * 客户端生成的消息id，仅在convType为PERSON或TEAM含此字段，字符串类型
     */
    private String msgidClient;
    /**
     * 服务端生成的消息id，可转为Long型数据
     */
    private String msgidServer;
    /**
     * 重发标记：0不是重发, 1是重发。
     * 仅在convType为PERSON或TEAM时含此字段，
     * 可转为Integer类型数据
     */
    private String resendFlag;
    /**
     * 若convType为PERSON或CUSTOM_PERSON，则to为消息接收者的用户账号，字符串类型；
     * 若convType为TEAM或CUSTOM_TEAM，则to为tid，即群id，可转为Long型数据
     */
    private String to;
    /**
     * 自定义系统通知消息是否存离线:0：不存，1：存。
     * 仅在convType为CUSTOM_PERSON或CUSTOM_TEAM时含此字段，
     * 可转为Integer类型数据
     */
    private String customSafeFlag;
    /**
     * 自定义系统通知消息推送文本。
     * 仅在convType为CUSTOM_PERSON或CUSTOM_TEAM时含此字段，
     * 字符串类型
     */
    private String customApnsText;
    /**
     * 跟本次群操作有关的用户accid，
     * 仅在convType为TEAM或CUSTOM_TEAM时含此字段，
     * 字符串类型。
     */
    private String tMembers;
    /**
     * 消息扩展字段
     */
    private String ext;
    /**
     * 标识是否被反垃圾，
     * 仅在被反垃圾时才有此字段，
     * 可转为Boolean类型数据
     */
    private String antispam;

    //登录登出事件消息
    private String accid;
    private String clientIp;
    private String clientType;
    private String code;
    private String sdkVersion;
    private String timestamp;

    //聊天室消息
    private String fromAvator;
    private String fromExt;
    private String roleInfoTimetag;
    private String roomId;

    //音视频通话/白板消息
    private String channelId;
    private String createtime;
    private String duration;
    private String live;
    private String members;
    private String status;
    private String type;

    //音视频/白板文件下载信息
    private String fileinfo;

    //单聊/群聊消息撤回
    private String clientId;
    private String deleteTime;
    private String from;
    private String msgId;
    private String selfMsg;
    private String sendTime;

    //主播管理员进出聊天室事件
    private String event;

    //专线电话通话结束回调
    private String callback;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getConvType() {
        return convType;
    }

    public void setConvType(String convType) {
        this.convType = convType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getFromClientType() {
        return fromClientType;
    }

    public void setFromClientType(String fromClientType) {
        this.fromClientType = fromClientType;
    }

    public String getFromDeviceId() {
        return fromDeviceId;
    }

    public void setFromDeviceId(String fromDeviceId) {
        this.fromDeviceId = fromDeviceId;
    }

    public String getFromNick() {
        return fromNick;
    }

    public void setFromNick(String fromNick) {
        this.fromNick = fromNick;
    }

    public String getMsgTimestamp() {
        return msgTimestamp;
    }

    public void setMsgTimestamp(String msgTimestamp) {
        this.msgTimestamp = msgTimestamp;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgidClient() {
        return msgidClient;
    }

    public void setMsgidClient(String msgidClient) {
        this.msgidClient = msgidClient;
    }

    public String getMsgidServer() {
        return msgidServer;
    }

    public void setMsgidServer(String msgidServer) {
        this.msgidServer = msgidServer;
    }

    public String getResendFlag() {
        return resendFlag;
    }

    public void setResendFlag(String resendFlag) {
        this.resendFlag = resendFlag;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCustomSafeFlag() {
        return customSafeFlag;
    }

    public void setCustomSafeFlag(String customSafeFlag) {
        this.customSafeFlag = customSafeFlag;
    }

    public String getCustomApnsText() {
        return customApnsText;
    }

    public void setCustomApnsText(String customApnsText) {
        this.customApnsText = customApnsText;
    }

    public String gettMembers() {
        return tMembers;
    }

    public void settMembers(String tMembers) {
        this.tMembers = tMembers;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getAntispam() {
        return antispam;
    }

    public void setAntispam(String antispam) {
        this.antispam = antispam;
    }

    @Override
    public String toString() {
        return "NeteaseMessageDto{" +
                "id=" + id +
                ", attach='" + attach + '\'' +
                ", body='" + body + '\'' +
                ", convType='" + convType + '\'' +
                ", eventType='" + eventType + '\'' +
                ", fromAccount='" + fromAccount + '\'' +
                ", fromClientType='" + fromClientType + '\'' +
                ", fromDeviceId='" + fromDeviceId + '\'' +
                ", fromNick='" + fromNick + '\'' +
                ", msgTimestamp='" + msgTimestamp + '\'' +
                ", msgType='" + msgType + '\'' +
                ", msgidClient='" + msgidClient + '\'' +
                ", msgidServer='" + msgidServer + '\'' +
                ", resendFlag='" + resendFlag + '\'' +
                ", to='" + to + '\'' +
                ", customSafeFlag='" + customSafeFlag + '\'' +
                ", customApnsText='" + customApnsText + '\'' +
                ", tMembers='" + tMembers + '\'' +
                ", ext='" + ext + '\'' +
                ", antispam='" + antispam + '\'' +
                '}';
    }
}
