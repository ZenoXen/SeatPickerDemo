package org.seat.web.admin;

import org.seat.beans.Seat;
import org.seat.services.SeatService;
import org.seat.services.UserService;
import org.seat.utils.Message;
import org.seat.utils.SeatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping(value = "/seat")
@Controller
public class SeatController {
    @Autowired
    private SeatService seatService;
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Seat getSeatByUser(HttpSession session) {
        int uid = userService.getUserByName((String) session.getAttribute("uname")).getUid();
        return seatService.getSeatByUser(uid);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Seat seatLocation(
            @RequestParam("fid") int fid,
            @RequestParam("rownum") int rownum,
            @RequestParam("colnum") int colnum) {
        Seat seat = seatService.getSeatByLocation(fid, rownum, colnum);
        return seat;
    }

    @ResponseBody
    @RequestMapping(value = "/status", method = RequestMethod.PUT)
    public Message updateSeatStatus(@RequestBody SeatEntity seat) {
        Message message = new Message();
        message.setSuccessful(seatService.setSeatStatus(seat.getFid(), seat.getRownum(),
                seat.getColnum(), seat.getSeatStatus()));
        return message;
    }

    @ResponseBody
    @RequestMapping(value = "/cancel", method = RequestMethod.PUT)
    public Message cancelSeat(@RequestBody SeatEntity seat) {
        Message message = new Message();
        message.setSuccessful(seatService.cancelSeat(seat.getFid(), seat.getRownum(), seat.getColnum()));
        return message;
    }

    @ResponseBody
    @RequestMapping(value = "/release", method = RequestMethod.PUT)
    public Message releaseSeat(@RequestBody SeatEntity seat) {
        Message message = new Message();
        message.setSuccessful(seatService.releaseSeat(seat.getFid(), seat.getRownum(), seat.getColnum()));
        return message;
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.PUT)
    public Message registerSeat(@RequestBody SeatEntity seat) {
        Message message = new Message();
        message.setSuccessful(seatService.registerSeat(seat.getFid(), seat.getRownum(), seat.getColnum()));
        return message;
    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public Message updateSeatUser(@RequestBody SeatEntity se, HttpSession session) {
        Message message = new Message();
        int uid = userService.getUserByName((String) session.getAttribute("uname")).getUid();
        message.setSuccessful(seatService.setSeatUserAndAppointment(se.getFid(),
                se.getRownum(), se.getColnum(), uid));
        return message;
    }
}
