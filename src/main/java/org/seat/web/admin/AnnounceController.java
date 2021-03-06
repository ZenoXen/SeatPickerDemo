package org.seat.web.admin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.seat.beans.Announcement;
import org.seat.beans.User;
import org.seat.beans.UserExample;
import org.seat.mappers.AnnouncementMapper;
import org.seat.services.AnnouncementService;
import org.seat.utils.AnnouncementPage;
import org.seat.utils.Message;
import org.seat.utils.PageUtils;
import org.seat.utils.UserPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/announce")
public class AnnounceController {
    @Autowired
    AnnouncementService service;
    @ResponseBody
    @RequestMapping(value = "/page/{pageNum}",method = RequestMethod.GET)
    public AnnouncementPage announcePage(@PathVariable("pageNum")int pageNum){
        AnnouncementPage announcementPage=null;
        announcementPage=service.getAnnouncementPage(pageNum);
        return announcementPage;
    }
    @ResponseBody
    @RequestMapping(value = "/{announcementId}",method = RequestMethod.GET)
    public Announcement announcement(@PathVariable("announcementId")int announcementId){
        Announcement announcement=service.getAnnouncementById(announcementId);
        return announcement;
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public Message updateAnnouncement(@RequestBody Announcement announcement){
        Message message=new Message();
        announcement.setAnnouncementDate(new Date());
        message.setSuccessful(service.updateAnnouncement(announcement));
        return message;
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public Message deleteAnnouncement(@RequestBody Announcement announcement){
        Message message=new Message();
        message.setSuccessful(service.deleteAnnoucementById(announcement));
        return message;
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Message addAnnouncement(@RequestBody Announcement announcement){
        announcement.setAnnouncementDate(new Date());
        Message message=new Message();
        message.setSuccessful(service.addAnnouncement(announcement));
        return message;
    }
}
