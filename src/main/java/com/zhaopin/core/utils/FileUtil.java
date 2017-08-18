package com.zhaopin.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by SYJ on 2017/5/23.
 */
public class FileUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

    public FileUtil() {
    }

    public static Properties loadProperties(Class classz, String resources) {
        InputStream inputstream = classz.getClassLoader().getResourceAsStream(resources);
        Properties properties = new Properties();

        try {
            properties.load(inputstream);
            Properties e = properties;
            return e;
        } catch (IOException var14) {
            LOGGER.error("loadProperties[classz{},resources{},exception{}]", new Object[]{classz, resources, var14.getMessage()});
        } finally {
            try {
                inputstream.close();
            } catch (IOException var13) {
                LOGGER.error("loadProperties,inputstream close error", CommonUtil.getExceptionAllinformation(var13));
            }

        }

        return new Properties();
    }
}
