package org.seat.services;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.seat.beans.Announcement;
import org.seat.beans.AnnouncementExample;
import org.seat.beans.Appointment;
import org.seat.mappers.AppointmentMapper;
import org.seat.utils.AppointmentPage;
import org.seat.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentMapper mapper;
    public AppointmentPage getAppointmentPage(int pageNum){
        AppointmentPage appointmentPage=new AppointmentPage();
        Page<Appointment> page= PageHelper.startPage(pageNum, PageUtils.pageSize);
        page.setReasonable(true);
        List<Appointment> appointments=mapper.getAllAppointmentRecords();
        PageInfo<Appointment> pageInfo=new PageInfo<Appointment>(appointments,PageUtils.pageListSize);
        appointmentPage.setAppointmentList(appointments);
        appointmentPage.setPageNum(pageNum);
        appointmentPage.setPageList(PageUtils.parsePageList(pageInfo.getNavigatepageNums()));
        appointmentPage.setPageCount(pageInfo.getPages());
        return appointmentPage;
    }
    public AppointmentPage getAppointmentPageByUid(int pageNum,int uid){
        AppointmentPage appointmentPage=new AppointmentPage();
        Page<Appointment> page= PageHelper.startPage(pageNum, PageUtils.pageSize);
        page.setReasonable(true);
        List<Appointment> appointments=mapper.getAllAppointmentRecordsByUid(uid);
        PageInfo<Appointment> pageInfo=new PageInfo<Appointment>(appointments,PageUtils.pageListSize);
        appointmentPage.setAppointmentList(appointments);
        appointmentPage.setPageNum(pageNum);
        appointmentPage.setPageList(PageUtils.parsePageList(pageInfo.getNavigatepageNums()));
        appointmentPage.setPageCount(pageInfo.getPages());
        return appointmentPage;
    }
    public Appointment getAppointmentById(int id){
        return mapper.getAppointmentById(id);
    }
}
