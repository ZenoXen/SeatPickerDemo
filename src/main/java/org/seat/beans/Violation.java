package org.seat.beans;

import java.util.Date;

//违规记录
public class Violation {
    private Integer vid;
    //违规用户
    private User user;
    //违规记录生成时间
    private Date vtime;
    //违规记录产生的座位
    private Seat seat;

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    @Override
    public String toString() {
        return "Violation{" +
                "vid=" + vid +
                ", user=" + user +
                ", vtime=" + vtime +
                ", seat=" + seat +
                '}';
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getVtime() {
        return vtime;
    }

    public void setVtime(Date vtime) {
        this.vtime = vtime;
    }
}