package org.seat.beans;

import lombok.Data;

import java.util.Date;

//选座系统用户表
@Data
public class User {
    private Integer uid;

    private String uname;

    private String upwd;

    //是否已被禁用，0未禁用，1已禁用
    private Byte isforbidden = 0;

    //用户自动解冻时间
    private Date unlockTime;

}