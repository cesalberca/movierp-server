package com.movierp.server.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/user")
    public User user(@RequestParam(value="id") int id) {
        UserService userService = new UserService();
        return userService.getUser(id);
    }
}
