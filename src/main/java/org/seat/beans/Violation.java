package org.seat.beans;

import java.util.Date;

public class Violation {
    private Integer vid;
    private User user;
    private Date vtime;
    private Seat seat;
    public Integer getVid() {
        return vid;
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

    public void setVid(Integer vid) {
        this.vid = vid;
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