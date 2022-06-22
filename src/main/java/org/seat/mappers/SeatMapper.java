package org.seat.mappers;

import org.seat.beans.Seat;

import java.util.List;

public interface SeatMapper {
    Seat getSeatById(int sid);

    int addSeatsForFloor(List<Seat> seats);

    Seat getSeatByLocation(int fid, int rownum, int colnum);

    int updateSeatStatus(int fid, int rownum, int colnum, int status);

    int updateSeatAppointment(int fid, int rownum, int colnum, int aid);

    int updateSeatUser(int fid, int rownum, int colnum, int uid);

    Seat getSeatByUser(int uid);

    Seat getSeatByAppointment(int aid);

    int releaseSeat(int fid, int rownum, int colnum);

    int registerSeat(int fid, int rownum, int colnum);

    int releaseSeats(List<Integer> appointmentIds);
}
