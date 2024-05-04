package com.BusReservation.Project.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.BusReservation.Project.Respositary.UserDetailRespositary;
import com.BusReservation.Project.UserDetails.UserDetail;

@Service
public class UserDetailService {
    @Autowired
    private UserDetailRespositary userDetailRespositary;


    public void addUserDetail(@RequestBody UserDetail userDetail)
    {

    userDetailRespositary.save(userDetail);
    }

    public void cancleTicket(@RequestBody UserDetail cancleUserDetail)
    {
     userDetailRespositary.delete(cancleUserDetail);
    }
    public List<UserDetail> getAllBookingDetails()
    {
        return userDetailRespositary.findAll();
    }
    public UserDetail getUserDetailByid(UserDetail getUserDetail)
    {
        Optional<UserDetail> userDetail= userDetailRespositary.findById(getUserDetail.getAddarNum());
        if(userDetail.isPresent())
        {
            getUserDetail = userDetail.get();
            return getUserDetail;
        }
        return null;
    }
   
}
