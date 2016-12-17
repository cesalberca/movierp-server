package com.movierp.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private static final String template = "Hello, %s!";

    @RequestMapping("/user")
    public User user(@RequestParam(value="name", defaultValue="World") String name) {
        return new User(String.format(template, name));
    }
}
