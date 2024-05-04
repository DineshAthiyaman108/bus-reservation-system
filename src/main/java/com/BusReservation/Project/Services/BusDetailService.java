package com.BusReservation.Project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BusReservation.Project.BusDetail.BusDetails;
import com.BusReservation.Project.Respositary.BusdetailsRespositary;

@Service
public class BusDetailService {
   
    @Autowired
    private BusdetailsRespositary busRespositary;

    public void addBusDetails(BusDetails bus)
    {
         
        busRespositary.save(bus);
    }
    public Optional<BusDetails> getdDetails(int busNo)
    {
       return busRespositary.findById(busNo);
    }
    public List<BusDetails> getAllBusDetails()
    {
        return busRespositary.findAll();
    }
    
    
}
