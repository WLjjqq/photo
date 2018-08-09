package com.wx.bean;

import java.util.Date;

public class Ttoken {
    private Integer id;
    private String accessToken;
    private Integer expiresIn;
    private Date createTime;

    public Ttoken() {

    }

    public Ttoken(Integer id, String accessToken, Integer expiresIn, Date createTime) {
        this.id = id;
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Ttoken{" +
                "id=" + id +
                ", accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", createTime=" + createTime +
                '}';
    }
}
