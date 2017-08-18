package com.zhaopin.core.utils;

import org.apache.commons.lang.NullArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Properties;

/**
 * Created by SYJ on 2017/5/23.
 */
public class ConfigUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigUtil.class);

    public ConfigUtil() {
    }

    public static String getProperty(Properties properties, String key) {
        if(properties != null) {
            String val = properties.getProperty(key, "");
            return val;
        } else {
            return null;
        }
    }

    public static String urlCombine(String path1, String path2) {
        if(CommonUtil.isNullOrEmpty(path1)) {
            throw new NullArgumentException("path1");
        } else {
            if(CommonUtil.isNullOrEmpty(path2)) {
                path2 = "";
            }

            path1 = CommonUtil.trimEnd(path1, "?");
            path1 = CommonUtil.trimEnd(path1, "&");
            path2 = CommonUtil.trimStart(path2, "?");
            path2 = CommonUtil.trimStart(path2, "&");
            return path1.indexOf("?") > -1?path1 + "&" + path2:path1 + "?" + path2;
        }
    }

    public static String urlCombine(String path1, Map<String, Object> params) {
        String str_param = HttpClientUtil.getUrlParamsByMap(params);
        return urlCombine(path1, str_param);
    }
}
