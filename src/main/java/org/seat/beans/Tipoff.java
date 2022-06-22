package org.seat.beans;

import lombok.Data;

import java.util.Date;

//举报记录
@Data
public class Tipoff {
    private Integer tid;
    //被举报者
    private User accused;
    //举报时间
    private Date ttime;
    //举报者
    private User tipster;
    //举报关联的座位
    private Seat seat;
    //备注
    private String remark;

}
