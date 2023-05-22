package com.EventBookingSystemAPI.EventBookingSystemAPI.services;

import com.EventBookingSystemAPI.EventBookingSystemAPI.DTO.TicketsSalesReportDTO;
import com.EventBookingSystemAPI.EventBookingSystemAPI.repositories.TicketSalesReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ReportsServices {

    @Autowired
    private TicketSalesReportRepository ticketSalesReportRepository;

    public List<TicketsSalesReportDTO> generateTicketSalesReport(Date startDate, Date endDate) {
        return ticketSalesReportRepository.getTicketSalesReportData(startDate, endDate);
    }


    public List<TicketsSalesReportDTO> generateTicketsSalesReport(Date startDate, Date endDate) {
        return ticketSalesReportRepository.findTicketSalesReportData(startDate, endDate);
    }


}
