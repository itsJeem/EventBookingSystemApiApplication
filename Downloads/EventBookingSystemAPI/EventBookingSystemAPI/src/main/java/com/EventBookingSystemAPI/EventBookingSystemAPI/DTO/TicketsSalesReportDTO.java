package com.EventBookingSystemAPI.EventBookingSystemAPI.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
@Data
@Setter
@Getter
public class TicketsSalesReportDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String eventName;
    private Date date;
    private String location;
    private int ticketsSold;
    private Double revenue;


}
