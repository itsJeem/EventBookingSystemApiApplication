package com.EventBookingSystemAPI.EventBookingSystemAPI.repositories;

import com.EventBookingSystemAPI.EventBookingSystemAPI.models.Booking;
import com.EventBookingSystemAPI.EventBookingSystemAPI.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query("SELECT e FROM Event e WHERE e.date BETWEEN :fromDate AND :toDate AND e.location = :location")
    List<Event> searchEventsBetweenDatesAndLocation(@Param("fromDate") Date fromDate,
                                                    @Param("toDate") Date toDate,



                                                    @Param("location") String location);

}
