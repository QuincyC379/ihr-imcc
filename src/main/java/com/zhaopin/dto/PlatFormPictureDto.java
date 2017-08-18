package com.zhaopin.dto;

/**
 * 平台图片
 * Created by SYJ on 2017/5/18.
 */
public class PlatFormPictureDto {

    private Integer high;
    private Integer wide;
    private String smallUrl;
    private String reduceUrl;

    public PlatFormPictureDto() {
    }

    public PlatFormPictureDto(Integer high, Integer wide, String smallUrl, String reduceUrl) {
        this.high = high;
        this.wide = wide;
        this.smallUrl = smallUrl;
        this.reduceUrl = reduceUrl;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    public Integer getWide() {
        return wide;
    }

    public void setWide(Integer wide) {
        this.wide = wide;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getReduceUrl() {
        return reduceUrl;
    }

    public void setReduceUrl(String reduceUrl) {
        this.reduceUrl = reduceUrl;
    }

    @Override
    public String toString() {
        return "PlatFormPictureDto{" +
                "high=" + high +
                ", wide=" + wide +
                ", smallUrl='" + smallUrl + '\'' +
                ", reduceUrl='" + reduceUrl + '\'' +
                '}';
    }
}
