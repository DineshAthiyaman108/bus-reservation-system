package com.BusReservation.Project.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.BusReservation.Project.BusDetail.BusDetails;

@Configuration
public class AppConfig {

    @Bean
    public BusDetails busDetails() {
        return new BusDetails();
    }
}