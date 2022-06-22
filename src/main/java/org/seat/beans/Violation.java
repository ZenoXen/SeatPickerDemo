package org.seat.beans;

import lombok.Data;

import java.util.Date;

//违规记录
@Data
public class Violation {
    private Integer vid;
    //违规用户
    private User user;
    //违规记录生成时间
    private Date vtime;
    //违规记录产生的座位
    private Seat seat;

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

}