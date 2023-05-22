package com.EventBookingSystemAPI.EventBookingSystemAPI.services;

import com.EventBookingSystemAPI.EventBookingSystemAPI.DTO.TicketsSalesReportDTO;
import com.EventBookingSystemAPI.EventBookingSystemAPI.models.Booking;
import com.EventBookingSystemAPI.EventBookingSystemAPI.repositories.BookingRepository;
import com.EventBookingSystemAPI.EventBookingSystemAPI.repositories.TicketSalesReportRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.awt.print.Book;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportsServices {

//    @Autowired
//    private TicketSalesReportRepository ticketSalesReportRepository;
    @Autowired
    private BookingRepository bookingRepository;

//    public List<TicketsSalesReportDTO> generateTicketSalesReport(Date startDate, Date endDate) {
//        return ticketSalesReportRepository.getTicketSalesReportData(startDate, endDate);
//    }
//
//
//    public List<TicketsSalesReportDTO> generateTicketsSalesReport(Date startDate, Date endDate) {
//        return ticketSalesReportRepository.findTicketSalesReportData(startDate, endDate);
//    }

    public static final String pathToReports = "C:\\Users\\user014\\Downloads\\Reports";

    public String generateReportForTicketsSales() throws FileNotFoundException, JRException {
        List<Booking> bookings = (List<Booking>) bookingRepository.findAll();
        List<TicketsSalesReportDTO> ticketsSalesReportDTOS = new ArrayList<>();

        for (Booking booking: bookings) {
            TicketsSalesReportDTO dto = new TicketsSalesReportDTO();
            dto.setEventName(booking.getEvent().getName());
            dto.setDate(booking.getEvent().getDate());
            dto.setLocation(booking.getEvent().getLocation());
            dto.setTicketsSold(booking.getNumberOfTickets());


            ticketsSalesReportDTOS.add(dto);
        }

        File file = ResourceUtils.getFile("classpath:TicketsEventsReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ticketsSalesReportDTOS);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "jeem");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\TicketsEventsReport.pdf");
        return "Report generated : " + pathToReports+"\\TicketsEventsReport.pdf";
    }


}
