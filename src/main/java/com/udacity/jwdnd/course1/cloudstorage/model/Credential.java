package com.udacity.jwdnd.course1.cloudstorage.model;

public class Credential {
    private Integer credentialid;
    private Integer userid;
    private String url;
    private String username;
    private String key;
    private String password;

    public Credential(String url, String userName, String password) {
        this.url = url;
        this.username = userName;
        this.password = password;
    }

    public Integer getUserId() {
        return userid;
    }

    public Integer getCredentialId() {
        return credentialid;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getKey() {
        return key;
    }

    public void setUserId(Integer userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setCredentialId(Integer credentialid) {
        this.credentialid = credentialid;
    }
}
