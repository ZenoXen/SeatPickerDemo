package org.seat.web.admin;

import org.seat.beans.Seat;
import org.seat.beans.Tipoff;
import org.seat.services.SeatService;
import org.seat.services.TipoffService;
import org.seat.services.UserService;
import org.seat.utils.Message;
import org.seat.utils.TipoffEntity;
import org.seat.utils.TipoffPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/tipoff")
public class TipoffController {
    @Autowired
    private TipoffService tipoffService;
    @Autowired
    private SeatService seatService;
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Message addTipoff(@RequestBody TipoffEntity entity, HttpSession session) {
        Message message = new Message();
        Seat seat = seatService.getSeatByLocation(entity.getFid(),
                entity.getRownum(), entity.getColnum());
        int accuseId = seat.getUser().getUid();
        int tipsterId = userService.getUserByName((String) session.getAttribute("uname")).getUid();
        message.setSuccessful(tipoffService.addTipoff(accuseId, tipsterId, seat.getSid(), entity.getRemark()));
        return message;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public Message handleTipoff(@RequestBody Tipoff tipoff) {
        Message message = new Message();
        message.setSuccessful(tipoffService.verifyTipoff(tipoff.getTid()));
        return message;
    }

    @ResponseBody
    @RequestMapping(value = "/page/{pageNum}", method = RequestMethod.GET)
    public TipoffPage tipoffPage(@PathVariable("pageNum") int pageNum) {
        TipoffPage page = tipoffService.getTipoffPage(pageNum);
        return page;
    }

    @ResponseBody
    @RequestMapping(value = "/{tid}", method = RequestMethod.GET)
    public Tipoff tipoff(@PathVariable("tid") int tid) {
        return tipoffService.getTipoffById(tid);
    }
}
