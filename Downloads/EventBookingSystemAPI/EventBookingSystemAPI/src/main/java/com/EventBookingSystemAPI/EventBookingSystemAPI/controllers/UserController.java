package com.EventBookingSystemAPI.EventBookingSystemAPI.controllers;

import com.EventBookingSystemAPI.EventBookingSystemAPI.models.User;
import com.EventBookingSystemAPI.EventBookingSystemAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestParam String username, @RequestParam String password) {
      return userService.registerUser(username, password);
    }
}
