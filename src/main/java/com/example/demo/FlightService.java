package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Service
public class FlightService {


    public Flight getFlightInfo() {
        // TODO Auto-generated method stub
        Flight flight = new Flight();
        flight.setDeparts(new Date(2017 - 1900, 4, 21, 10, 34));
        List<Ticket> list = new ArrayList<>();
        Ticket t1 = new Ticket();
        Person passenger = new Person();
        passenger.setFirstname("Test name");
        passenger.setLastname("Test name ");
        t1.setPrice("200");
        t1.setPassengers(passenger);
        list.add(t1);
        flight.setTickets(list);
        return flight;
    }

    public List<Flight> getFlightList() {

        Flight f1 = new Flight();
        f1.setDeparts(new Date(2017, 4, 21, 10, 34));
        List<Ticket> list1 = new ArrayList<>();
        Ticket t1 = new Ticket();
        Person passenger1 = new Person();
        passenger1.setFirstname("Test name1");
        passenger1.setLastname(null);
        t1.setPrice("200");
        t1.setPassengers(passenger1);
        list1.add(t1);
        f1.setTickets(list1);

        /*Flight f2 = new Flight();*/
        /*f2.setDeparts(new Date(2017, 4, 21, 10, 34));
        List<Ticket> list2 = new ArrayList<>();
        Ticket t2 = new Ticket();
        Person passenger2 = new Person();
        passenger2.setFirstname(null);
        passenger2.setLastname(null);
        t2.setPrice(null);
        t2.setPassengers(passenger2);
        list2.add(t2);
        f2.setTickets(list2);*/
        return Arrays.asList(f1);
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Flight {
/*
        @JsonInclude(JsonInclude.Include.NON_NULL)
*/
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        @JsonProperty("Departs")
        private Date departs;

/*
        @JsonInclude(JsonInclude.Include.NON_NULL)
*/
        @JsonProperty("Tickets")
        private List<Ticket> tickets=new ArrayList<>();


        public Date getDeparts() {
            return departs;
        }

        public void setDeparts(Date departs) {
            this.departs = departs;
        }

        @JsonProperty("Tickets")
        public List<Ticket> getTickets() {
            return tickets;
        }

        public void setTickets(List<Ticket> tickets) {
            this.tickets = tickets;
        }

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class Ticket {
/*
        @JsonInclude(JsonInclude.Include.NON_NULL)
*/
        @JsonProperty("Passenger")
        private Person passengers;

/*
        @JsonInclude(JsonInclude.Include.NON_NULL)
*/
        @JsonProperty("Price")
        private String price;

        public Person getPassengers() {
            return passengers;
        }

        public void setPassengers(Person passengers) {
            this.passengers = passengers;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }



    public Ticket getFlightTicketPrice(Flight ticketlist) {
        // TODO Auto-generated method stub
        List<Ticket> ticketInfo = ticketlist.getTickets();
        Integer sum = 0;
        int i = 0;
        while (i < ticketInfo.size()) {
            Ticket t2 = ticketInfo.get(i);
            sum = sum + Integer.parseInt(t2.getPrice());
            i++;
        }
        Result result = new Result();
        result.setPrice(sum.toString());
        return result;

    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class Person {
/*
        @JsonInclude(JsonInclude.Include.NON_NULL)
*/
        @JsonProperty("Firstname")
        private String firstname;

/*
        @JsonInclude(JsonInclude.Include.NON_NULL)
*/
        @JsonProperty("Lastname")
        private String lastname;

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }
    }

    public static class Result extends Ticket {
        @JsonProperty("Result")
        private String price;

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

    }

}
