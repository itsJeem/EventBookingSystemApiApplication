package com.EventBookingSystemAPI.EventBookingSystemAPI.services;

import com.EventBookingSystemAPI.EventBookingSystemAPI.models.Event;
import com.EventBookingSystemAPI.EventBookingSystemAPI.models.User;
import com.EventBookingSystemAPI.EventBookingSystemAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User registerUser(String username,String password) {
        if (username == null || password == null) {
            System.out.println("Invalid registration data");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);


        if (isUsernameExists(username)) {
            System.out.println("Username already exists");
        }


        System.out.println("User registered successfully");
        return userRepository.save(user);
    }


    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }


    public boolean isUsernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

}
