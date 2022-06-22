package org.seat.utils;

import lombok.Data;
import org.seat.beans.Appointment;

import java.util.List;

@Data
public class AppointmentPage {
    private List<Appointment> appointmentList;
    private List<Integer> pageList;
    private Integer pageCount;
    private Integer pageNum;
}
