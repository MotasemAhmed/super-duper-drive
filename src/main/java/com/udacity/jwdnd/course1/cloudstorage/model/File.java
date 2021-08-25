package com.udacity.jwdnd.course1.cloudstorage.model;

public class File {
    private Integer fileId;
    private Integer userId;
    private String fileName;
    private String contentType;
    private String fileSize;
    private byte[] fileData;

    public File(Integer fileId, String fileName, String contentType, String fileSize, Integer userId, byte[] fileData) {
        this.fileId = fileId;
        this.userId = userId;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.fileData = fileData;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public Integer getFileId() {
        return fileId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getOwner() {
        return userId;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
