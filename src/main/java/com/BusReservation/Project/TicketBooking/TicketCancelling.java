package com.BusReservation.Project.TicketBooking;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BusReservation.Project.BusDetail.BusDetails;
import com.BusReservation.Project.Respositary.UserDetailRespositary;
import com.BusReservation.Project.Services.BusDetailService;
import com.BusReservation.Project.UserDetails.UserDetail;

@Component
public class TicketCancelling {
    
    @Autowired
    private UserDetailRespositary userDetailRespositary;

    @Autowired
    private BusDetailService busDetailService;

    public UserDetail ticketCancelling(UserDetail userDetail) {
        Optional<UserDetail> detail = userDetailRespositary.findById(userDetail.getAddarNum());     
        if (detail.isPresent()) {
            UserDetail cancelUserDetail = detail.get();
            int busNo = cancelUserDetail.getBusNo();
            
            Optional<BusDetails> busOptional = busDetailService.getdDetails(busNo);
            if (busOptional.isPresent()) {
                BusDetails bus = busOptional.get();
                
                // Update available seats in the bus
                bus.setAvaliableSeats(bus.getAvaliableSeats() + cancelUserDetail.getSeats());
                busDetailService.addBusDetails(bus);
                
                // Remove the cancelled booking from the user repository
                userDetailRespositary.delete(cancelUserDetail);
                
                // Return the cancelled user detail
                return cancelUserDetail;
            }
        }
        
        return null;
    }
}
