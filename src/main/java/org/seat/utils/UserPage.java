package org.seat.utils;

import org.seat.beans.User;

import java.util.List;

public class UserPage {
    private List<User> userList;
    private List<Integer> pageList;
    private Integer pageCount;
    private Integer pageNum;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Integer> getPageList() {
        return pageList;
    }

    public void setPageList(List<Integer> pageList) {
        this.pageList = pageList;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "UserPage{" +
                "userList=" + userList +
                ", pageList=" + pageList +
                ", pageCount=" + pageCount +
                ", pageNum=" + pageNum +
                '}';
    }
}
