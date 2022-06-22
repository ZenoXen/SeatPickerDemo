package org.seat.beans;

//座位
public class Seat {
    private Integer sid;
    //所属楼层
    private Floor floor;
    //座位当前预约记录
    private Appointment appointment;
    //0座位不存在，不可用；1座位可选；2座位已选；3使用中
    private Integer seatStatus;
    //当前使用座位的用户
    private User user;
    //座位行号
    private Integer rownum;
    //座位列号
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
