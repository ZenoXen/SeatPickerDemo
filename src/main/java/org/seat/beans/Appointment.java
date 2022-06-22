package org.seat.beans;

import java.util.Date;

//预约记录
public class Appointment {
    private Integer aid;
    private User user;
    private Date atime;
    //0代表当前预约记录未取消；1为已取消
    private byte isCanceled = 0;
    private Date releaseTime;
    //该预约记录对应的座位是否已释放，0未释放，1已释放
    private byte isReleased;
    //预约记录签到时间
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
