package org.seat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpSession session) {
        if (session.getAttribute("uname") != null)
            return "index";
        else if (session.getAttribute("adminName") != null)
            return "adminPage";
        return "login";
    }
}
