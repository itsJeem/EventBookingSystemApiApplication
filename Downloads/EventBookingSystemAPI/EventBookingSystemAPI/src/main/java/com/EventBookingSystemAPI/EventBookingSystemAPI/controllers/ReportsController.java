package com.EventBookingSystemAPI.EventBookingSystemAPI.controllers;


import com.EventBookingSystemAPI.EventBookingSystemAPI.DTO.TicketsSalesReportDTO;
import com.EventBookingSystemAPI.EventBookingSystemAPI.repositories.TicketSalesReportRepository;
import com.EventBookingSystemAPI.EventBookingSystemAPI.services.ReportsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("tickets")
public class ReportsController {

    @Autowired
    private ReportsServices reportService;

    @GetMapping("/ticketSales")
    public List<TicketsSalesReportDTO> getTicketSalesReport(@RequestParam Date startDate,
                                                            @RequestParam Date endDate) {
        return reportService.generateTicketsSalesReport(startDate, endDate);
    }
}
