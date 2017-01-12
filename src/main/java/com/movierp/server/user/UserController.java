package com.movierp.server.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("/create")
    @ResponseBody
    public String create(String email, String name) {
        User user;
        try {
            user = new User(name);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getId() + ")";
    }

    @RequestMapping("/get-by-name")
    @ResponseBody
    public String getByEmail(String name) {
        String userId;
        try {
            User user = userDao.findByName(name);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }

    @Autowired
    private UserDao userDao;
}
