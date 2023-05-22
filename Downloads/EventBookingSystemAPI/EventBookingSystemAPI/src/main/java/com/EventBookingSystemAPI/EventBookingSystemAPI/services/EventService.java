package com.EventBookingSystemAPI.EventBookingSystemAPI.services;

import com.EventBookingSystemAPI.EventBookingSystemAPI.models.Event;
import com.EventBookingSystemAPI.EventBookingSystemAPI.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;


    public Event createEvent(String name, String date, String location, int ticketsAvailable) {
        if (name == null || date == null || location == null) {
            System.out.print( "Invalid event data");
        }
        Event event = new Event();
        event.setName(name);
        event.setDate(Date.valueOf(date));
        event.setLocation(location);
        event.setTicketsAvailable(ticketsAvailable);

        System.out.print( "Event created successfully");
        return eventRepository.save(event);
    }

    public Event getEventById(Integer eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

    public List<Event> searchEventsBetweenDatesAndLocation(Date fromDate, Date toDate, String location) {
        return eventRepository.searchEventsBetweenDatesAndLocation(fromDate, toDate, location);
    }

    public List<Event> getAllEvents() {
        return eventRepository.getAllEvents();
    }
}
