package org.seat.web.login;

import org.seat.beans.Admin;
import org.seat.beans.User;
import org.seat.services.AdminService;
import org.seat.services.UserService;
import org.seat.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@RequestMapping("/account")
@Controller
public class AccountController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public Message userLogin(@RequestBody User user,HttpSession session){
        Message message=new Message();
        message.setSuccessful(userService.checkUser(user));
        if(message.isSuccessful())
            session.setAttribute("uname",user.getUname());
        return message;
    }
    @ResponseBody
    @RequestMapping(value = "/admin",method = RequestMethod.POST)
    public Message adminLogin(@RequestBody Admin admin,HttpSession session){
        Message message=new Message();
        message.setSuccessful(adminService.checkAdmin(admin));
        if(message.isSuccessful())
            session.setAttribute("adminName",admin.getAdminName());
        return message;
    }
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Message userRegister(@RequestBody User user,HttpSession session){
        Message message=new Message();
        message.setSuccessful(userService.insertUser(user));
        if(message.isSuccessful())
            session.setAttribute("uname",user.getUname());
        return message;
    }
}
