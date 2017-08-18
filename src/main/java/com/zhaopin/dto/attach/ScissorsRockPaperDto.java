package com.zhaopin.dto.attach;

/**
 * 自定义消息:剪刀 石头 布(attach附加字段的type=1)
 * Created by SYJ on 2017/5/18.
 */
public class ScissorsRockPaperDto {
    private Integer value;//1：石头；2：剪刀；3：布

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ScissorsRockPaperDto{" +
                "value=" + value +
                '}';
    }
}
