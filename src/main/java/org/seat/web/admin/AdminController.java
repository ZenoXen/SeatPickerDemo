package org.seat.web.admin;

import org.seat.utils.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Map adminName(HttpSession session) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("adminName", session.getAttribute("adminName"));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/exit", method = RequestMethod.PUT)
    public Message exitLogin(HttpSession session) {
        Message message = new Message();
        message.setSuccessful(false);
        if (session.getAttribute("adminName") != null) {
            session.removeAttribute("adminName");
            message.setSuccessful(true);
        }
        return message;
    }
}
