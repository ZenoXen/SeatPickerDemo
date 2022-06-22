package org.seat.beans;

import java.util.List;

//楼层
public class Floor {
    private Integer fid;
    //楼层名称
    private String fname;
    //楼层行数
    private Integer row;
    //楼层列数
    private Integer col;
    //楼层所有座位
    private List<Seat> seats;

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "fid=" + fid +
                ", fname='" + fname + '\'' +
                ", row=" + row +
                ", col=" + col +
                '}';
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
