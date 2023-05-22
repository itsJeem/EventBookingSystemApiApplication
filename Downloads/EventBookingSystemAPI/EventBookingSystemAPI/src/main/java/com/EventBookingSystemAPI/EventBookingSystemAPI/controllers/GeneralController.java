package com.EventBookingSystemAPI.EventBookingSystemAPI.controllers;


//import org.springframework.security.access.prepost.PreAuthorize;
import com.EventBookingSystemAPI.EventBookingSystemAPI.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "generalController")
public class GeneralController {

    @Autowired
    SlackClient slackClient;
    @GetMapping(value = "test")
/*
    @PreAuthorize("hasRole('USER')")
*/
    public String test(){
        return "${spring.profiles.active}";
    }

    @GetMapping("/admin")
/*
    @PreAuthorize("hasRole('ADMIN')")
*/
    public String adminOnly() {
        return "You are an admin!";
    }


    @GetMapping(value =  "slackMessage")
    public void message(@RequestParam String text) {
        slackClient.sendMessage(text);
    }
}
