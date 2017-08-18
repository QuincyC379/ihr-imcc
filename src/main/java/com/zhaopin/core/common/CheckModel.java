package com.zhaopin.core.common;

/**
 * 校验信息
 * Created by SYJ on 2017/5/22.
 */
public class CheckModel {
    private String md5;
    private String checksum;
    private String curtime;

    public CheckModel() {
    }

    public CheckModel(String md5, String checksum, String curtime) {
        this.md5 = md5;
        this.checksum = checksum;
        this.curtime = curtime;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getCurtime() {
        return curtime;
    }

    public void setCurtime(String curtime) {
        this.curtime = curtime;
    }

    @Override
    public String toString() {
        return "CheckModel{" +
                "md5='" + md5 + '\'' +
                ", checksum='" + checksum + '\'' +
                ", curtime='" + curtime + '\'' +
                '}';
    }
}
