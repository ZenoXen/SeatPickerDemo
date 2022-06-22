package org.seat.beans;

import lombok.Data;

import java.util.Date;

//预约记录
@Data
public class Appointment {
    private Integer aid;
    private User user;
    private Date atime;
    //0代表当前预约记录未取消；1为已取消
    private byte isCanceled = 0;
    private Date releaseTime;
    //该预约记录对应的座位是否已释放，0未释放，1已释放
    private byte isReleased;
    //预约记录签到时间
    private Date registerTime;
    private Short aspan;
}
