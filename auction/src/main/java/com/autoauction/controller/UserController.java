package com.autoauction.controller;

import com.autoauction.entity.User;
import com.autoauction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/test")
    public String test() {
        return "Working";

    }

    @PostMapping("/register")
    public User register(
            @RequestBody User user) {

        return service.saveUser(user);
    }
}
