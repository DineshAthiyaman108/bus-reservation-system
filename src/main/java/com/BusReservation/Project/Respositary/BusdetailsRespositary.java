package com.BusReservation.Project.Respositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BusReservation.Project.BusDetail.BusDetails;

public interface BusdetailsRespositary extends JpaRepository<BusDetails,Integer> {
    
}
