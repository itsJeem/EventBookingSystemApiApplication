package com.EventBookingSystemAPI.EventBookingSystemAPI.repositories;

import com.EventBookingSystemAPI.EventBookingSystemAPI.DTO.TicketsSalesReportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketSalesReportRepository extends JpaRepository<TicketsSalesReportDTO, Integer> {


    @Query("SELECT new com.example.dto.TicketSalesReportDTO(e.name, e.date, e.location, COUNT(b.id)) " +
            "FROM Event e LEFT JOIN Booking b ON e.id = b.eventId " +
            "WHERE e.date BETWEEN :startDate AND :endDate " +
            "GROUP BY e.id")
    List<TicketsSalesReportDTO> getTicketSalesReportData(@Param("startDate") Date startDate, @Param("endDate") Date endDate);



    List<TicketsSalesReportDTO> findTicketSalesReportData(Date startDate, Date endDate);
}
