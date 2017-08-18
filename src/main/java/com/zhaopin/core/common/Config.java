package com.zhaopin.core.common;

import com.zhaopin.core.utils.CommonUtil;
import com.zhaopin.core.utils.ConfigUtil;
import com.zhaopin.core.utils.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * 配置类
 * Created by SYJ on 2017/5/23.
 */
public class Config {
    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);
    /***
     * 发送消息
     */
    private static String sendMessageUrl;

    /***
     * 创建会话
     */
    private static String createDiscussionUrl;

    static {
        String resource = "resource/resource.properties";
        try {
            Properties properties = FileUtil.loadProperties(Config.class, resource);
            sendMessageUrl = ConfigUtil.getProperty(properties, "sendMessageUrl");
            createDiscussionUrl = ConfigUtil.getProperty(properties, "createDiscussionUrl");
        } catch (Exception ex) {
            LOGGER.error("Config类从文件resource.properties加载配置属性失败,异常信息[{}]", CommonUtil.getExceptionAllinformation(ex));
        }
    }

    public static String getSendMessageUrl() {
        return sendMessageUrl;
    }

    public static String getCreateDiscussionUrl() {
        return createDiscussionUrl;
    }
}
