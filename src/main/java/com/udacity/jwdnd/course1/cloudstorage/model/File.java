package com.udacity.jwdnd.course1.cloudstorage.model;

import java.util.Arrays;

public class File {
    private Integer fileId;
    private Integer userId;
    private String filename;
    private String contentType;
    private String filesize;
    private byte[] fileData;

    public File(Integer fileId, Integer userId, String filename, String contentType, String filesize, byte[] fileData) {
        this.fileId = fileId;
        this.userId = userId;
        this.filename = filename;
        this.contentType = contentType;
        this.filesize = filesize;
        this.fileData = fileData;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileid=" + fileId +
                ", userId=" + userId +
                ", filename='" + filename + '\'' +
                ", contentType='" + contentType + '\'' +
                ", filesize='" + filesize + '\'' +
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

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
