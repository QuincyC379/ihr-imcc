package com.zhaopin.core.common;

import com.zhaopin.core.utils.CommonUtil;
import com.zhaopin.core.utils.FileUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by SYJ on 2017/5/23.
 */
public class EnvConfig {
    private static String defaultEnvCode = "prod";
    private static String envCode;
    private static Properties defaultConfig;

    public EnvConfig() {
    }

    public static boolean isDevEnv() {
        return envCode == "dev";
    }

    public static boolean isQAEnv() {
        return envCode == "test";
    }

    public static boolean isProdnv() {
        return envCode == "prod";
    }

    public static String getEnv() {
        return envCode;
    }

    public static String setEnv(String env) {
        envCode = env;
        return env;
    }

    static {
        try {
            Properties envCodes = FileUtil.loadProperties(EnvConfig.class, "env.properties");
            if(envCodes != null && !CommonUtil.isNullOrEmpty(envCodes.getProperty("dev"))) {
                envCode = envCodes.getProperty("dev").trim();
            }
        } catch (Exception var1) {
            var1.printStackTrace();
        }

        List envCodes1 = Arrays.asList(new String[]{"prod", "test", "dev"});
        if(!envCodes1.contains(envCode)) {
            envCode = defaultEnvCode;
        }

    }

}
