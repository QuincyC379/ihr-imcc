package com.zhaopin.dto;

/**
 * Created by SYJ on 2017/5/18.
 */
public class PlatFormFileDto {

    private String fileName;//文件名称
    private String fileUrl;//文件url
    private String fileExt;//扩展属性(json)
    private String fileSize;//文件大小
    private String fileType;//文件后缀
    private String hash;

    public PlatFormFileDto() {
    }

    public PlatFormFileDto(String fileName, String fileUrl, String fileExt, String fileSize, String fileType, String hash) {
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.fileExt = fileExt;
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.hash = hash;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "PlatFormFileDto{" +
                "fileName='" + fileName + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", fileExt='" + fileExt + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", fileType='" + fileType + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}
