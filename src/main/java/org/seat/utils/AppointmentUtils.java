package org.seat.utils;

import org.seat.beans.Appointment;
import org.seat.beans.User;

import java.util.Date;

public class AppointmentUtils {
    public static Appointment createAppointment(int uid, Date atime, Date releaseTime){
        Appointment appointment=new Appointment();
        User user=new User();
        user.setUid(uid);
        appointment.setUser(user);
        appointment.setAtime(atime);
        appointment.setReleaseTime(releaseTime);
        return appointment;
    }
}
