package org.seat.services;

import org.seat.beans.Appointment;
import org.seat.beans.Seat;
import org.seat.mappers.AppointmentMapper;
import org.seat.mappers.SeatMapper;
import org.seat.utils.AppointmentUtils;
import org.seat.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class SeatService {
    @Autowired
    private SeatMapper seatMapper;
    @Autowired
    private AppointmentMapper appointmentMapper;
    public boolean setSeatUserAndAppointment(int fid,int rownum,int colnum,int uid){
        Seat seat=getSeatByLocation(fid,rownum,colnum);
        if(seat.getUser()!=null) return false;
        Date atime=new Date();
        Date releaseTime=TimeUtils.getAutoReleaseTime(atime);
        Appointment appointment=AppointmentUtils.createAppointment(uid,atime,releaseTime);
        int ret1=appointmentMapper.insertAppointment(appointment);
        int ret2= seatMapper.updateSeatStatus(fid,rownum,colnum,2);
        int ret3= seatMapper.updateSeatUser(fid,rownum,colnum,uid);
        int ret4=seatMapper.updateSeatAppointment(fid,rownum,colnum,appointment.getAid());
        return ret1+ret2+ret3+ret4==4;
    }
    public boolean cancelSeat(int fid,int rownum,int colnum){
        Seat seat=getSeatByLocation(fid,rownum,colnum);
        if(seat.getUser()==null)return false;
        int ret1=appointmentMapper.updateCancelStatus(seat.getAppointment().getAid());
        int ret2=seatMapper.releaseSeat(fid,rownum,colnum);
        return ret1+ret2==2;
    }
    public boolean registerSeat(int fid,int rownum,int colnum){
        Seat seat=getSeatByLocation(fid,rownum,colnum);
        if(seat.getUser()==null)return false;
        int ret1=appointmentMapper.updateRegisterTime(seat.getAppointment().getAid(),new Date());
        int ret2=seatMapper.registerSeat(fid,rownum,colnum);
        return ret1+ret2==2;
    }
    public boolean releaseSeat(int fid,int rownum,int colnum){
        Seat seat=getSeatByLocation(fid,rownum,colnum);
        if(seat.getUser()==null)return false;
        int ret1=appointmentMapper.updateReleaseStatus(seat.getAppointment().getAid());
        int ret2=seatMapper.releaseSeat(fid,rownum,colnum);
        int aspan=TimeUtils.calculateTimeDiff(seat.getAppointment().getRegisterTime(),new Date());
        int ret3=appointmentMapper.updateAspan(seat.getAppointment().getAid(),aspan);
        return ret1+ret2+ret3==3;
    }
    public boolean setSeatStatus(int fid,int rownum,int colnum,int status){
        return seatMapper.updateSeatStatus(fid,rownum,colnum,status)>0;
    }

    public Seat getSeatByUser(int uid){
        return seatMapper.getSeatByUser(uid);
    }

    public Seat getSeatByLocation(int fid,int rownum,int colnum){
        return seatMapper.getSeatByLocation(fid,rownum,colnum);
    }
}
