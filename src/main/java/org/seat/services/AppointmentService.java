package org.seat.services;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.seat.beans.Appointment;
import org.seat.mappers.AppointmentMapper;
import org.seat.utils.AppointmentPage;
import org.seat.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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

    //todo 30s执行一次定时任务，自动释放过期座位
    @Scheduled(fixedRate = 30000)
    public void scheduledReleaseSeats(){
        log.info("自动释放已过期座位：");

    }
}
