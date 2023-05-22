package com.EventBookingSystemAPI.EventBookingSystemAPI.controllers;

import com.EventBookingSystemAPI.EventBookingSystemAPI.models.Booking;
import com.EventBookingSystemAPI.EventBookingSystemAPI.models.Event;
import com.EventBookingSystemAPI.EventBookingSystemAPI.models.User;
import com.EventBookingSystemAPI.EventBookingSystemAPI.services.BookingService;
import com.EventBookingSystemAPI.EventBookingSystemAPI.services.EventService;
import com.EventBookingSystemAPI.EventBookingSystemAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/createNewBooking")
    @PreAuthorize("hasRole('USER')")
    public Booking createBooking(@RequestParam Integer eventId, @RequestParam Integer userId, @RequestParam int numberOfTickets) {
    return bookingService.createBooking(eventId, userId, numberOfTickets);
    }

    @GetMapping("/getUserBookings")
    @PreAuthorize("hasRole('USER')")
    public List<Booking> getUserBookings(@RequestParam("userId") Integer userId) {
        return bookingService.getBookingsByUserId(userId);
    }

    @DeleteMapping("/cancelBooking")
    @PreAuthorize("hasRole('USER')")
    public void deleteBooking(@RequestParam("bookingId") Integer bookingId) {
        bookingService.deleteBooking(bookingId);
    }

    @GetMapping("/getAllBookings")
    @PreAuthorize("hasRole('USER')")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }



}
