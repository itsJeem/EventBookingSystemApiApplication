package com.EventBookingSystemAPI.EventBookingSystemAPI.Schedule;

import com.EventBookingSystemAPI.EventBookingSystemAPI.Slack.SlackClient;
import com.EventBookingSystemAPI.EventBookingSystemAPI.models.Event;
import com.EventBookingSystemAPI.EventBookingSystemAPI.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@RequestMapping(value="schedule")
public class Schedule {

    @Autowired
    SlackClient slackClient;

    @Autowired
    EventService eventService;


    @Scheduled( cron = "0 */5 * * * * ")
    @RequestMapping(value = "getEventsUpdates" , method = RequestMethod.GET)
    public List<Event> getEventsUpdates(){
        List<Event> events = eventService.getAllEvents();

        for ( Event e : events) {
            slackClient.sendMessage(e.getName());
            slackClient.sendMessage(e.getLocation());
            slackClient.sendMessage(String.valueOf(e.getTicketsAvailable()));
        }
        return events;

    }

}
