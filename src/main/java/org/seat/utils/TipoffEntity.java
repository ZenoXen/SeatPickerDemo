package org.seat.utils;

public class TipoffEntity {
    private Integer fid;
    private Integer rownum;
    private Integer colnum;
    private String remark;

    @Override
    public String toString() {
        return "TipoffEntity{" +
                "fid=" + fid +
                ", rownum=" + rownum +
                ", colnum=" + colnum +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
