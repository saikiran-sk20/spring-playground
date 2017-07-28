package com.example.demo;

/*
import java.util.List;
*/

import com.example.demo.FlightService.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class FlightController {
    @Autowired
    private FlightService service;

    @GetMapping("/flights/flight")
    public Flight getFlight() {
        Flight flightInfo = service.getFlightInfo();
        return flightInfo;
    }

    @GetMapping("/flights")
    public List<Flight> getAllFlights() {
        List<Flight> flightlistInfo = service.getFlightList();
        return flightlistInfo;
    }
    @PostMapping(value="/flights/tickets/total",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public FlightService.Ticket getFlightTicketSum(@RequestBody Flight ticketlist) {
/*        System.out.println(flightSum.getTickets().get(0));
        System.out.println(ticketlist.getTickets().get(0).getPassengers().getFirstname());*/
        FlightService.Ticket pricesum =service.getFlightTicketPrice(ticketlist);
        return pricesum;

    }
//FlightSum flightTicketSum = service.getFlightTicket();
//return flightTicketSum;
//	FlightSum flightTicketSum = service.getFlightTicket();


}