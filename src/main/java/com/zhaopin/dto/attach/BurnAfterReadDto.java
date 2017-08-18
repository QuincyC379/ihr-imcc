package com.zhaopin.dto.attach;

/**
 * 阅后即焚(type=2)
 * Created by SYJ on 2017/5/18.
 */
public class BurnAfterReadDto {

    private String md5;//阅后即焚的图片的md5值
    private String url;//阅后即焚的图片地址
    private Boolean fired;//标记在查看前是否焚毁，一般都为false，可以不理会

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getFired() {
        return fired;
    }

    public void setFired(Boolean fired) {
        this.fired = fired;
    }

    @Override
    public String toString() {
        return "BurnAfterReadDto{" +
                "md5='" + md5 + '\'' +
                ", url='" + url + '\'' +
                ", fired=" + fired +
                '}';
    }
}
