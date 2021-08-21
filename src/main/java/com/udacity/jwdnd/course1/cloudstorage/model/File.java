package com.udacity.jwdnd.course1.cloudstorage.model;

import java.util.Arrays;

public class File {
    private int fileid;
    private int userid;
    private String filename;
    private String contenttype;
    private String filesize;
    private byte[] filedata;

    public File(int fileid, int userid, String filename, String contenttype, String filesize, byte[] filedata) {
        this.fileid = fileid;
        this.userid = userid;
        this.filename = filename;
        this.contenttype = contenttype;
        this.filesize = filesize;
        this.filedata = filedata;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileid=" + fileid +
                ", userid=" + userid +
                ", filename='" + filename + '\'' +
                ", contenttype='" + contenttype + '\'' +
                ", filesize='" + filesize + '\'' +
                ", filedata=" + Arrays.toString(filedata) +
                '}';
    }

    public int getFileid() {
        return fileid;
    }

    public void setFileid(int fileid) {
        this.fileid = fileid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public byte[] getFiledata() {
        return filedata;
    }

    public void setFiledata(byte[] filedata) {
        this.filedata = filedata;
    }
}
