package org.seat.mappers;

import org.seat.beans.Appointment;
import org.seat.utils.AppointmentPage;

import java.util.Date;
import java.util.List;

public interface AppointmentMapper {
    List<Appointment> getAllAppointmentRecords();
    List<Appointment> getAllAppointmentRecordsByUid(int uid);
    Appointment getAppointmentById(int aid);
    int insertAppointment(Appointment appointment);
    int updateRegisterTime(int aid,Date registerTime);
    int updateAspan(int aid,int aspan);
    int updateReleaseStatus(int aid);
    int updateCancelStatus(int aid);
    List<Integer> findAllAppointsToRelease();
}
