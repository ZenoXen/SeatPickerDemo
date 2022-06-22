package org.seat.utils;

import org.seat.beans.Tipoff;

import java.util.List;

public class TipoffPage {
    private List<Tipoff> tipoffList;
    private List<Integer> pageList;
    private Integer pageCount;
    private Integer pageNum;

    @Override
    public String toString() {
        return "TipoffPage{" +
                "tipoffList=" + tipoffList +
                ", pageList=" + pageList +
                ", pageCount=" + pageCount +
                ", pageNum=" + pageNum +
                '}';
    }

    public List<Tipoff> getTipoffList() {
        return tipoffList;
    }

    public void setTipoffList(List<Tipoff> tipoffList) {
        this.tipoffList = tipoffList;
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
