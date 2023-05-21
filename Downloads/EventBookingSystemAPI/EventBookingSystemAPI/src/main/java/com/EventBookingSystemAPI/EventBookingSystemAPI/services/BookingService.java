package com.EventBookingSystemAPI.EventBookingSystemAPI.services;

import com.EventBookingSystemAPI.EventBookingSystemAPI.models.Booking;
import com.EventBookingSystemAPI.EventBookingSystemAPI.models.Event;
import com.EventBookingSystemAPI.EventBookingSystemAPI.models.User;
import com.EventBookingSystemAPI.EventBookingSystemAPI.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    EventService eventService;
    @Autowired
    UserService userService;

    public Booking createBooking(Integer eventId, Integer userId,int numberOfTickets) {

        Event event = eventService.getEventById(eventId);
        if (event == null) {
            System.out.println("Event not found");
        }
        User user = userService.getUserById(userId);
//        if (user == null) {
//            System.out.println("User not found");
//        }

        if (event.getTicketsAvailable() < numberOfTickets) {
            System.out.println("no tickets available");
        }

        Booking booking = new Booking();
        booking.setEvent(event);
        booking.setNumberOfTickets(numberOfTickets);
        booking.setUser(user);


        event.setTicketsAvailable(event.getTicketsAvailable() - numberOfTickets);
        eventService.updateEvent(event);

//        System.out.println("Booking created successfully");

        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUserId(Integer userId) {
        return bookingRepository.findByUserId(userId);
    }

    public void deleteBooking(Integer bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

}
