package com.zhaopin.core.common;

/**
 * Created by SYJ on 2017/5/23.
 */
public class Constants {

    public static final String ENCODE_CHARSET = "utf-8";
    public static final String NETEASE_STATUS_CODE_KEY = "code";
    /**
     * 云信请求HEADER中的AppKey
     */
    public static final String NETEASE_REQUEST_HEADER_APPKEY = "AppKey";
    /**
     * 云信请求HEADER中的CurTime
     */
    public static final String NETEASE_REQUEST_HEADER_CURTIME = "CurTime";
    /**
     * 云信请求HEADER中的MD5
     */
    public static final String NETEASE_REQUEST_HEADER_MD5 = "MD5";
    /**
     * 云信请求HEADER中的CheckSum
     */
    public static final String NETEASE_REQUEST_HEADER_CHECKSUM = "CheckSum";
    /**
     * 版本号，当前版本为1
     */
    public static final Integer PLATFORM_REQUEST_HEADER_VERSION = 1;
    /**
     * 客户端请求服务器
     */
    public static final Integer PLATFORM_REQUEST_HEADER_TYPE = 1;
    /**
     * 讨论组相关
     */
    public static final Integer PLATFORM_REQUEST_HEADER_GROUP = 2;
    /**
     * 发送消息
     */
    public static final Integer PLATFORM_REQUEST_HEADER_SIGNALL = 1;
    /**
     * 和平台约定调用平台创建讨论组接口时,参数token传此固定值.
     */
    public static final String PLATFORM_PASSPORT_TOKEN = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    /**
     * 平台接口发送消息成功的状态码
     */
    public static final int PLATFORM_SUCCESS_CODE = 200;
    /**
     * AppKey[用于访问云信]
     */
    public static final String APPKEY = "315787a004e9f2c873c4be998cb5918f";
    /**
     * appSecret[用于访问云信]
     */
    public static final String APPSECRET = "897e308fe876";
    /**
     * 平台发送消息接口URL
     */
    //public static final String PLATFORM_SEND_MESSAGE_URL = Config.getSendMessageUrl();
    /**
     * 平台创建讨论组接口URL
     */
    //public static final String PLATFORM_CREATE_DISCUSSION_URL = Config.getCreateDiscussionUrl();

}
