package org.seat.beans;

import lombok.Data;

import java.util.Date;

//公告
@Data
public class Announcement {
    private Integer announcementId;

    //标题
    private String title;

    //公告日期
    private Date announcementDate;

    //内容
    private String content;

}