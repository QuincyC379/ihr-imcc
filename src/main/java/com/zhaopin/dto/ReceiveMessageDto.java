package com.zhaopin.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by SYJ on 2017/5/17.
 */
public class ReceiveMessageDto {
    @JSONField(name = "header")
    private HeaderDto headerDto;
    @JSONField(name = "body")
    private ReceiveBodyDto receiveBodyDto;

    public HeaderDto getHeaderDto() {
        return headerDto;
    }

    public void setHeaderDto(HeaderDto headerDto) {
        this.headerDto = headerDto;
    }

    public ReceiveBodyDto getReceiveBodyDto() {
        return receiveBodyDto;
    }

    public void setReceiveBodyDto(ReceiveBodyDto receiveBodyDto) {
        this.receiveBodyDto = receiveBodyDto;
    }

    @Override
    public String toString() {
        return "ReceiveMessageDto{" +
                "headerDto=" + headerDto +
                ", receiveBodyDto=" + receiveBodyDto +
                '}';
    }
}
