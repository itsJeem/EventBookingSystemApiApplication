package com.EventBookingSystemAPI.EventBookingSystemAPI.controllers;


import com.EventBookingSystemAPI.EventBookingSystemAPI.DTO.TicketsSalesReportDTO;
import com.EventBookingSystemAPI.EventBookingSystemAPI.repositories.TicketSalesReportRepository;
import com.EventBookingSystemAPI.EventBookingSystemAPI.services.ReportsServices;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("reportsController")
public class ReportsController {

    @Autowired
    private ReportsServices reportService;

    @RequestMapping(value = "ticketSalesReport")
/*
    @PreAuthorize("hasRole('USER')")
*/
    public void schoolReport() throws JRException, FileNotFoundException {
        reportService.generateReportForTicketsSales();
    }
}
