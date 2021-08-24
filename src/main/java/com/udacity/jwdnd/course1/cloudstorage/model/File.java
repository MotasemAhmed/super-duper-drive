package com.udacity.jwdnd.course1.cloudstorage.model;

import java.util.Arrays;

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

    @Override
    public String toString() {
        return "File{" +
                "fileid=" + fileId +
                ", userId=" + userId +
                ", fileName='" + fileName + '\'' +
                ", contentType='" + contentType + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", fileData=" + Arrays.toString(fileData) +
                '}';
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getUserId() {
        return userId;
    }
    public Integer getOwner() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
