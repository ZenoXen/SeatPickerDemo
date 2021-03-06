package org.seat.beans;

import java.util.Date;

public class Seat {
    private Integer sid;
    private Floor floor;
    private Appointment appointment;
    private Integer seatStatus;
    private User user;
    private Integer rownum;
    private Integer colnum;

    @Override
    public String toString() {
        return "Seat{" +
                "sid=" + sid +
                ", floor=" + floor +
                ", appointment=" + appointment +
                ", seatStatus=" + seatStatus +
                ", user=" + user +
                ", rownum=" + rownum +
                ", colnum=" + colnum +
                '}';
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Integer getRownum() {
        return rownum;
    }

    public void setRownum(Integer rownum) {
        this.rownum = rownum;
    }

    public Integer getColnum() {
        return colnum;
    }

    public void setColnum(Integer colnum) {
        this.colnum = colnum;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Integer getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(Integer seatStatus) {
        this.seatStatus = seatStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
