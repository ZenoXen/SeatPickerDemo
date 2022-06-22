package org.seat.beans;


import lombok.Data;

//管理用户表
@Data
public class Admin {
    private Integer adminId;

    private String adminName;

    private String adminPwd;

}