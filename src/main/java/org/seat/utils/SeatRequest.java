package org.seat.utils;

public class SeatRequest {
    private Integer sid;
    private Integer fid;
    private Integer seatStatus;
    private Integer uid;
    private Integer rownum;
    private Integer colnum;

    @Override
    public String toString() {
        return "SeatEntity{" +
                "sid=" + sid +
                ", fid=" + fid +
                ", seatStatus=" + seatStatus +
                ", uid=" + uid +
                ", rownum=" + rownum +
                ", colnum=" + colnum +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(Integer seatStatus) {
        this.seatStatus = seatStatus;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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
}
