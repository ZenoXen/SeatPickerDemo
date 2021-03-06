package org.seat.utils;

import org.seat.beans.User;
import org.seat.beans.Violation;

import java.util.List;

public class ViolationPage {
    private List<Violation> violationList;
    private List<Integer> pageList;
    private Integer pageCount;
    private Integer pageNum;

    @Override
    public String toString() {
        return "ViolationPage{" +
                "violationList=" + violationList +
                ", pageList=" + pageList +
                ", pageCount=" + pageCount +
                ", pageNum=" + pageNum +
                '}';
    }

    public List<Violation> getViolationList() {
        return violationList;
    }

    public void setViolationList(List<Violation> violationList) {
        this.violationList = violationList;
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
}
