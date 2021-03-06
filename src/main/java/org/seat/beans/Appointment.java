package org.seat.beans;

import java.util.Date;

public class Appointment {
    private Integer aid;
    private User user;
    private Date atime;
    private byte isCanceled;
    private Date releaseTime;
    private byte isReleased;
    private Date registerTime;
    private Short aspan;

    @Override
    public String toString() {
        return "Appointment{" +
                "aid=" + aid +
                ", user=" + user +
                ", atime=" + atime +
                ", isCanceled=" + isCanceled +
                ", releaseTime=" + releaseTime +
                ", isReleased=" + isReleased +
                ", registerTime=" + registerTime +
                ", aspan=" + aspan +
                '}';
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public byte getIsReleased() {
        return isReleased;
    }

    public void setIsReleased(byte isReleased) {
        this.isReleased = isReleased;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getAtime() {
        return atime;
    }

    public void setAtime(Date atime) {
        this.atime = atime;
    }

    public Short getAspan() {
        return aspan;
    }

    public void setAspan(Short aspan) {
        this.aspan = aspan;
    }

    public byte getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(byte isCanceled) {
        this.isCanceled = isCanceled;
    }
}
