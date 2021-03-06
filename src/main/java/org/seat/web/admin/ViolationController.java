package org.seat.web.admin;

import org.seat.beans.Violation;
import org.seat.mappers.ViolationMapper;
import org.seat.services.ViolationService;
import org.seat.utils.Message;
import org.seat.utils.ViolationPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/violation")
public class ViolationController {
    @Autowired
    private ViolationService service;
    @ResponseBody
    @RequestMapping(value = "/page/{pageNum}",method = RequestMethod.GET)
    public ViolationPage violationPage(@PathVariable("pageNum") int pageNum){
        return service.getViolationPage(pageNum);
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public Message deleteViolation(@RequestBody Violation violation){
        Message message=new Message();
        message.setSuccessful(service.deleteViolation(violation.getVid()));
        return message;
    }
}
