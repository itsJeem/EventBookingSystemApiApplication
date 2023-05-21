package com.EventBookingSystemAPI.EventBookingSystemAPI.repositories;


import com.EventBookingSystemAPI.EventBookingSystemAPI.models.Booking;
import com.EventBookingSystemAPI.EventBookingSystemAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByUserId(Integer userId);

    void deleteById(Integer bookingId);

}
