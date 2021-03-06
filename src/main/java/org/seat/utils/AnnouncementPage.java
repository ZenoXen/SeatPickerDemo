package org.seat.utils;

import org.seat.beans.Announcement;
import org.seat.beans.User;

import java.util.List;

public class AnnouncementPage {
    private List<Announcement> announcementList;
    private List<Integer> pageList;
    private Integer pageCount;
    private Integer pageNum;

    @Override
    public String toString() {
        return "AnnouncePage{" +
                "announcementList=" + announcementList +
                ", pageList=" + pageList +
                ", pageCount=" + pageCount +
                ", pageNum=" + pageNum +
                '}';
    }

    public List<Announcement> getAnnouncementList() {
        return announcementList;
    }

    public void setAnnouncementList(List<Announcement> announcementList) {
        this.announcementList = announcementList;
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
