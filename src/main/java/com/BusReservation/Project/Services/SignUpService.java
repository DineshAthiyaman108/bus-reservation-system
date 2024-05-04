package com.BusReservation.Project.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BusReservation.Project.Respositary.SignUpRespository;
import com.BusReservation.Project.SignUp.SignUp;

@Service
public class SignUpService  {

@Autowired
private SignUpRespository signUpRespository;

public void addnewUser(SignUp signUp)
{
    signUpRespository.save(signUp);
}

public SignUp finByaadhar(int number)
{
  Optional<SignUp> signUp = signUpRespository.findById(number);
  if(signUp.isPresent())
  {
  return signUp.get();
  }
  return null;
}

}
