package org.seat.beans;

import java.util.Date;

public class Tipoff {
    private Integer tid;
    private User accused;
    private Date ttime;
    private User tipster;
    private Seat seat;
    private String remark;

    @Override
    public String toString() {
        return "Tipoff{" +
                "tid=" + tid +
                ", accused=" + accused +
                ", ttime=" + ttime +
                ", tipster=" + tipster +
                ", seat=" + seat +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public User getAccused() {
        return accused;
    }

    public void setAccused(User accused) {
        this.accused = accused;
    }

    public Date getTtime() {
        return ttime;
    }

    public void setTtime(Date ttime) {
        this.ttime = ttime;
    }

    public User getTipster() {
        return tipster;
    }

    public void setTipster(User tipster) {
        this.tipster = tipster;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
