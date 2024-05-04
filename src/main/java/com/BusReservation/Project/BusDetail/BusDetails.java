package com.BusReservation.Project.BusDetail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Bus_details")
public class BusDetails {
    @Id
    private int busNo;

    @Column(name="source_loc")
    private String sourceLocation;

    @Column(name="destination_loc")
    private String destinationLocation;

    @Column(name="bus_capacity")
    private int busCapacity;

    @Column(name="bus_date")
    private String date;

    @Column(name="Avaliable_seat")
    private int avaliableSeats=0;

    @Column(name="bus_ac")
    private String busAc="no";
}
