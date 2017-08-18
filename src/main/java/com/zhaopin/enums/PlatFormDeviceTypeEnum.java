package com.zhaopin.enums;

/**
 * 平台设备类型
 * Created by SYJ on 2017/5/18.
 */
public enum PlatFormDeviceTypeEnum {
    IOS(1),
    Android(2),
    windows(3),
    Mac(4);

    private Integer value;

    PlatFormDeviceTypeEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
