package com.BusReservation.Project.TicketBooking;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BusReservation.Project.BusDetail.BusDetails;
import com.BusReservation.Project.Services.BusDetailService;
import com.BusReservation.Project.UserDetails.UserDetail;
@Component
public class TicketBooking {
    private BusDetailService busDetailService;
    private BusDetails bus;
    
    @Autowired
    public TicketBooking(BusDetailService busDetailService, BusDetails bus) {
        this.busDetailService = busDetailService;
        this.bus = bus;
    }

    public boolean newBooking(UserDetail userDetail) {
        int busNo = userDetail.getBusNo();
        int bookedSeats = userDetail.getSeats();
        
        Optional<BusDetails> busDetailOptional = busDetailService.getdDetails(busNo);
        
        if (busDetailOptional.isPresent()) {
             bus = busDetailOptional.get();
            
            int availableSeats = bus.getAvaliableSeats();
            
            if (availableSeats >= bookedSeats) {
                int newAvailableSeats = availableSeats - bookedSeats;
                bus.setAvaliableSeats(newAvailableSeats);
                busDetailService.addBusDetails(bus);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

