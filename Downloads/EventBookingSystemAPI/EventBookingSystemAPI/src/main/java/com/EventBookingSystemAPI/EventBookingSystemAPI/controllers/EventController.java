package com.EventBookingSystemAPI.EventBookingSystemAPI.controllers;

import com.EventBookingSystemAPI.EventBookingSystemAPI.models.Event;
import com.EventBookingSystemAPI.EventBookingSystemAPI.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping (value = "events")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping("/createEvent")
    @PreAuthorize("hasRole('USER')")
    public Event createEvent(@RequestParam String name, @RequestParam String date, @RequestParam String location, @RequestParam int ticketsAvailable) {
        return eventService.createEvent(name, date,location,ticketsAvailable);
    }


    @GetMapping("/search")
    @PreAuthorize("hasRole('USER')")
    public List<Event> searchEvents(@RequestParam("fromDate") Date fromDate,
                                    @RequestParam("toDate") Date toDate,
                                    @RequestParam("location") String location) {
        return eventService.searchEventsBetweenDatesAndLocation(fromDate, toDate, location);
    }
}
