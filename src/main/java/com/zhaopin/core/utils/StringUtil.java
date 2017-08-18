package com.zhaopin.core.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    public StringUtil() {
    }

    public static boolean isNullOrZero(Integer param) {
        return param == null || param.intValue() == 0;
    }

    public static boolean isNullOrZero(Long param) {
        return param == null || param.intValue() == 0;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() <= 0;
    }

    public static List<Long> getSplitLongList(String value, String splitChar) {
        ArrayList valueList = new ArrayList();
        if(!isNullOrEmpty(value)) {
            String[] values = value.split(splitChar);

            for(int i = 0; i < values.length; ++i) {
                if(values[i] != "") {
                    valueList.add(Long.valueOf(getLong(values[i])));
                }
            }
        }

        return valueList;
    }

    public static int stringLength(String value) {
        if(isNullOrEmpty(value)) {
            return 0;
        } else {
            int valueLength = 0;
            value = value.replace("\r\n", "\n");
            String chinese = "[Α-￥]";

            for(int i = 0; i < value.length(); ++i) {
                String temp = value.substring(i, i + 1);
                if(temp.matches(chinese)) {
                    valueLength += 2;
                } else {
                    ++valueLength;
                }
            }

            return valueLength;
        }
    }

    public static List<String> getSplitList(String value, String splitChar) {
        ArrayList valueList = new ArrayList();
        if(!isNullOrEmpty(value)) {
            String[] values = value.split(splitChar);

            for(int i = 0; i < values.length; ++i) {
                if(values[i] != "") {
                    valueList.add(values[i]);
                }
            }
        }

        return valueList;
    }

    public static String padLeft(String oriStr, int len, char alexin) {
        String str = "";
        int strlen = oriStr.length();
        if(strlen < len) {
            for(int i = 0; i < len - strlen; ++i) {
                str = str + alexin;
            }
        }

        str = str + oriStr;
        return str;
    }

    public static String padRight(String oriStr, int len, char alexin) {
        String str = "";
        int strlen = oriStr.length();
        if(strlen < len) {
            for(int i = 0; i < len - strlen; ++i) {
                str = str + alexin;
            }
        }

        str = oriStr + str;
        return str;
    }

    public static String trimEnd(String str, String charStr) {
        return !isNullOrEmpty(str) && !isNullOrEmpty(charStr) && str.substring(str.length() - 1).equals(charStr)?str.substring(0, str.length() - 1):str;
    }

    public static String trimStart(String str, String charStr) {
        return !isNullOrEmpty(str) && !isNullOrEmpty(charStr) && str.startsWith(charStr)?str.substring(str.indexOf(charStr) + 1):str;
    }

    public static String Arr2Str(String... strArr) {
        String hostString = "";

        for(int i = 0; i < strArr.length; ++i) {
            hostString = hostString + "," + strArr[i];
        }

        if(hostString.startsWith(",")) {
            ;
        }

        hostString = hostString.substring(1, hostString.length());
        return hostString;
    }

    public static int getInt(Object obj) {
        int def = 0;
        if(obj != null) {
            try {
                def = Integer.parseInt(obj == null?"":obj.toString());
            } catch (Exception var3) {
                ;
            }
        }

        return def;
    }

    public static int getInt(Object obj, int def) {
        if(obj != null) {
            try {
                def = Integer.parseInt(obj == null?"":obj.toString());
            } catch (Exception var3) {
                ;
            }
        }

        return def;
    }

    public static long getLong(Object obj, long def) {
        if(obj != null) {
            try {
                def = Long.parseLong(obj == null?"":obj.toString());
            } catch (Exception var4) {
                ;
            }
        }

        return def;
    }

    public static long getLong(Object obj) {
        long def = 0L;
        if(obj != null) {
            try {
                def = Long.parseLong(obj == null?"":obj.toString());
            } catch (Exception var4) {
                ;
            }
        }

        return def;
    }

    public static double getDouble(Object obj, double def) {
        if(obj != null) {
            try {
                def = Double.parseDouble(obj == null?"":obj.toString());
            } catch (Exception var4) {
                ;
            }
        }

        return def;
    }

    public static double getDouble(Object obj) {
        double def = 0.0D;
        if(obj != null) {
            try {
                def = Double.parseDouble(obj == null?"":obj.toString());
            } catch (Exception var4) {
                ;
            }
        }

        return def;
    }

    public static String getString(Object obj) {
        String def = "";
        if(obj != null) {
            def = obj.toString();
        }

        return def;
    }

    public static String getString(Object obj, String def) {
        if(obj != null) {
            def = obj.toString();
        }

        return def;
    }
}
