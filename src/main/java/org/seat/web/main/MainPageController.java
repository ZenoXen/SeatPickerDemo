package org.seat.web.main;

import org.seat.beans.Announcement;
import org.seat.beans.Appointment;
import org.seat.beans.User;
import org.seat.mappers.AppointmentMapper;
import org.seat.services.AnnouncementService;
import org.seat.services.AppointmentService;
import org.seat.services.UserService;
import org.seat.services.ViolationService;
import org.seat.utils.AppointmentPage;
import org.seat.utils.Message;
import org.seat.utils.ViolationPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/main")
@Controller
public class MainPageController{
    @Autowired
    private UserService userService;
    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private ViolationService violationService;
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Map userName(HttpSession session){
        Map map=new HashMap<String,Object>();
        map.put("uname",session.getAttribute("uname"));
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/latestAnnouncement",method = RequestMethod.GET)
    public Announcement latestAnnouncement(){
        return announcementService.getLatest();
    }
    @ResponseBody
    @RequestMapping(value = "/exit",method = RequestMethod.PUT)
    public Message exitLogin(HttpSession session){
        Message message=new Message();
        message.setSuccessful(false);
        if(session.getAttribute("uname")!=null){
            session.removeAttribute("uname");
            message.setSuccessful(true);
        }
        return message;
    }
    @ResponseBody
    @RequestMapping(value = "/appointment/page/{pageNum}",method = RequestMethod.GET)
    public AppointmentPage appointmentPage(@PathVariable("pageNum") int pageNum,HttpSession session){
        User user=userService.getUserByName((String)session.getAttribute("uname"));
        return appointmentService.getAppointmentPageByUid(pageNum,user.getUid());
    }
    @ResponseBody
    @RequestMapping(value = "/appointment/{aid}",method = RequestMethod.GET)
    public Appointment appointment(@PathVariable("aid") int aid){
        return appointmentService.getAppointmentById(aid);
    }
    @ResponseBody
    @RequestMapping(value = "/violation/page/{pageNum}",method = RequestMethod.GET)
    public ViolationPage violationPage(@PathVariable("pageNum")int pageNum,HttpSession session){
        User user=userService.getUserByName((String)session.getAttribute("uname"));
        return violationService.getViolationPageByUid(pageNum,user.getUid());
    }
}
