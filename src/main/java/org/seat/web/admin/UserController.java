package org.seat.web.admin;

import org.seat.beans.User;
import org.seat.services.UserService;
import org.seat.utils.Message;
import org.seat.utils.UserPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/page/{pageNum}", method = RequestMethod.GET)
    public UserPage userPage(@PathVariable("pageNum") int pageNum) {
        UserPage userPage = null;
        userPage = userService.getUserPage(pageNum);
        return userPage;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public User getCurrentUser(HttpSession session) {
        return userService.getUserByName((String) session.getAttribute("uname"));
    }

    @ResponseBody
    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public User user(@PathVariable("uid") int uid) {
        User user = userService.getUserById(uid);
        return user;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public Message updateUserState(@RequestBody User user) {
        Message message = new Message();
        message.setSuccessful(userService.updateUserState(user));
        return message;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public Message deleteUser(@RequestBody User user) {
        Message message = new Message();
        message.setSuccessful(userService.deleteUserById(user));
        return message;
    }
}
