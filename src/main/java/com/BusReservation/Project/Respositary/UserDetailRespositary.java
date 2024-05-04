package com.BusReservation.Project.Respositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BusReservation.Project.UserDetails.UserDetail;

public interface UserDetailRespositary  extends JpaRepository<UserDetail,Integer> {
}
