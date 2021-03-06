package org.seat.utils;

import org.seat.beans.Announcement;
import org.seat.beans.Appointment;

import java.util.List;

public class AppointmentPage {
    private List<Appointment> appointmentList;
    private List<Integer> pageList;
    private Integer pageCount;
    private Integer pageNum;

    @Override
    public String toString() {
        return "AppointmentPage{" +
                "appointmentList=" + appointmentList +
                ", pageList=" + pageList +
                ", pageCount=" + pageCount +
                ", pageNum=" + pageNum +
                '}';
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
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
