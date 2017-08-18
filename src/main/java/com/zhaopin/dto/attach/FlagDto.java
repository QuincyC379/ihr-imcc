package com.zhaopin.dto.attach;

/**
 * 自定义消息类型:白板会话（type=4）
 * Created by SYJ on 2017/5/18.
 */
public class FlagDto {

    private Integer flag;//0：邀请白板会话；1：关闭白板会话

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "FlagDto{" +
                "flag=" + flag +
                '}';
    }
}
