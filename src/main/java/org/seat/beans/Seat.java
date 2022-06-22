package org.seat.beans;

import lombok.Data;

//座位
@Data
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

}
