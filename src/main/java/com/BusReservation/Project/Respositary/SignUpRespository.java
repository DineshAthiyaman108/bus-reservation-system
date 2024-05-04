package com.BusReservation.Project.Respositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BusReservation.Project.SignUp.SignUp;

public interface SignUpRespository  extends  JpaRepository<SignUp,Integer>
{

}
