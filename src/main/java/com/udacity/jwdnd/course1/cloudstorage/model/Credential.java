package com.udacity.jwdnd.course1.cloudstorage.model;

public class Credential {
    private int credentialid;
    private int userid;
    private String url;
    private String username;
    private String key;
    private String password;

    public Credential(int credentialid, int userid, String url, String username, String key, String password) {
        this.credentialid = credentialid;
        this.userid = userid;
        this.url = url;
        this.username = username;
        this.key = key;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "credentialid=" + credentialid +
                ", userid=" + userid +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", key='" + key + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getCredentialid() {
        return credentialid;
    }

    public void setCredentialid(int credentialid) {
        this.credentialid = credentialid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
