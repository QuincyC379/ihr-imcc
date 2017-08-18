package com.zhaopin.enums;

/**
 * Created by SYJ on 2017/6/2.
 */
public enum PlatFormSendTypeEnum {

    REQUEST(1), RESPONSE(2), OUT(3),IN(4);
    private Integer value;
    PlatFormSendTypeEnum(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }
}
