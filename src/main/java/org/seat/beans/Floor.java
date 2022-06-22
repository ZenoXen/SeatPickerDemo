package org.seat.beans;

import lombok.Data;

import java.util.List;

//楼层
@Data
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

}
