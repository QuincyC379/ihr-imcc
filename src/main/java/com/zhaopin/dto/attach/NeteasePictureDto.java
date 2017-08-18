package com.zhaopin.dto.attach;

/**
 * 云信图片附加信息
 * Created by SYJ on 2017/5/18.
 */
public class NeteasePictureDto extends BaseAttachDto {

    private String md5;//图片的md5值
    private Integer h;//图片的高
    private Integer size;//图片的大小
    private Integer w;//图片的宽
    private String name;//图片的名称
    private String url;//图片的url
    private String ext;//图片格式

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        this.h = h;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    @Override
    public String toString() {
        return "NeteasePictureDto{" +
                "md5='" + md5 + '\'' +
                ", h=" + h +
                ", size=" + size +
                ", w=" + w +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", ext='" + ext + '\'' +
                '}';
    }
}
