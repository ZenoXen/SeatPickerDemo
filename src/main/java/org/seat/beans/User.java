package org.seat.beans;

import java.util.Date;

//选座系统用户表
public class User {
    private Integer uid;

    private String uname;

    private String upwd;

    //是否已被禁用，0未禁用，1已禁用
    private Byte isforbidden = 0;

    //用户自动解冻时间
    private Date unlockTime;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public Byte getIsforbidden() {
        return isforbidden;
    }

    public void setIsforbidden(Byte isforbidden) {
        this.isforbidden = isforbidden;
    }

    public Date getUnlockTime() {
        return unlockTime;
    }

    public void setUnlockTime(Date unlockTime) {
        this.unlockTime = unlockTime;
    }
}