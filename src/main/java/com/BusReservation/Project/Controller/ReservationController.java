package com.BusReservation.Project.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.BusReservation.Project.BusDetail.BusDetails;
import com.BusReservation.Project.Services.BusDetailService;
import com.BusReservation.Project.Services.SignUpService;
import com.BusReservation.Project.Services.UserDetailService;
import com.BusReservation.Project.SignUp.SignUp;
import com.BusReservation.Project.TicketBooking.TicketBooking;
import com.BusReservation.Project.TicketBooking.TicketCancelling;
import com.BusReservation.Project.UserDetails.UserDetail;
import jakarta.servlet.http.HttpSession;

@RestController
public class ReservationController {

    @Autowired
    private BusDetailService busDetailServiceservice;
    @Autowired
    private UserDetailService userDetailService;
   @Autowired
   private TicketBooking bookingTicket;

   @Autowired
   private TicketCancelling ticketCancelling;

   @Autowired
   private SignUpService signUpService;

  



    @PostMapping("/newBus")
    public ModelAndView newBus(
        @RequestParam("userBusNo") int busNo,
        @RequestParam("sourceLocation") String sourceLocation,
        @RequestParam("destinationLocation") String destinationLocation,
        @RequestParam("busCapacity") int busCapacity,
        @RequestParam("date") String date,
        @RequestParam("avaliableSeats") int avaliableSeats,
        @RequestParam("busAc") String busAc ,HttpSession session)
    {
        ModelAndView modelAndView = new ModelAndView("AdminLoginPage");
        if (session.getAttribute("password") == null) {
        return modelAndView;
            
        }
        BusDetails bus = new BusDetails(busNo, sourceLocation, destinationLocation, busCapacity, date, avaliableSeats, busAc);
    busDetailServiceservice.addBusDetails(bus);
    modelAndView.setViewName("AdminPage");
    return modelAndView ;
    }

  
    @PostMapping("/newUser")
    public RedirectView addUserDetail(@RequestParam("userName") String userName,
    @RequestParam("userNumber") Long userNumber,
    @RequestParam("userEmail") String userEmail,
    @RequestParam("userBusNo") int userBusNo,
    @RequestParam("userSeat")int  userPassword,
    @RequestParam("date") String date,
    @RequestParam("userAadhar") int userAadhar
    )
    {
        UserDetail userDetail = new UserDetail(userAadhar, userPassword, userName, userAadhar, userEmail, userBusNo, date);
        if(bookingTicket.newBooking(userDetail))
        {
            userDetailService.addUserDetail(userDetail);
            return new RedirectView("/BookingSuccess");
        }
      return new RedirectView("/BookingUnSuccess");
      
    
    }
    @PostMapping("/cancleTicket")
    public RedirectView cancleTicket(@RequestParam("userName") String userName,
    @RequestParam("userBusNo")  int userBusNo,
    @RequestParam("userAadhar") int userAadhar,
    @RequestParam("userNumber") Long userNumber)
    {
        UserDetail detail = new UserDetail(userName, userNumber, userAadhar, userBusNo);
     UserDetail cancleUserDetail = ticketCancelling.ticketCancelling(detail);
     System.out.println(cancleUserDetail);
     if(cancleUserDetail!=null)
     {
      userDetailService.cancleTicket(cancleUserDetail);
      return new RedirectView("/ticketCancleSuccess");
     }
     return new RedirectView("/ticketCancleUnSuccess");
    }
    @GetMapping("/admin/getAllUser")
    public ModelAndView getAllBookingUser()
    {
        ModelAndView modelAndView = new ModelAndView();
        List<UserDetail> userDetail =  userDetailService.getAllBookingDetails();
        modelAndView.addObject("userDetail", userDetail);
        System.out.println(userDetail);
        modelAndView.setViewName("showAllBookingUser");
        return modelAndView;
    }
    @GetMapping("/getAllBusDetails")
    public ModelAndView getAllAndShowBusDetails(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        List<BusDetails> myList = busDetailServiceservice.getAllBusDetails();
        modelAndView.addObject("myList", myList);
        modelAndView.setViewName("ShowBusDetail"); // Thymeleaf template name
        return modelAndView;
    }


    @GetMapping("/getUserById")
    public UserDetail getUserDetailByid(@RequestBody UserDetail userDetail)
    {
        return userDetailService.getUserDetailByid(userDetail);
    }
    @GetMapping("/getBusByNo/{number}")
    public BusDetails getBusByNo(@PathVariable Integer number)
    {
        Optional<BusDetails> bus =  busDetailServiceservice.getdDetails(number);
        System.out.println(bus);
        if(bus.isPresent())
         return bus.get();
         else   
         return null;
    }
    @GetMapping("/User/singUp")
    public RedirectView signUp(@RequestParam("userName") String userName,
                       @RequestParam("userEmail") String userEmail,
                       @RequestParam("userPassword")String  userPassword,
                       @RequestParam("userAadhar") int userAadhar,
                       @RequestParam("userNumber") Long userNumber)
                        {
        SignUp signUp = new SignUp(userName, userEmail, userPassword, userAadhar, userNumber);
        signUpService.addnewUser(signUp);
        return new RedirectView("/signIn");
    }
    @PostMapping("/UserSingIn")
    public ModelAndView checkUserSign(@RequestParam("userName") String userName ,@RequestParam("userPassword") String UserPassword,@RequestParam("userAadhar")
      int aadharNum,HttpSession session)
    {
     ModelAndView view = new ModelAndView("SignIn");   
    SignUp user =   signUpService.finByaadhar(aadharNum);
    if(user!=null)
    {
         session.setAttribute("loggedInUser", user);
         view.setViewName("MainLanding");
         return view;
    }
    return view;
    
    }
    @GetMapping("/myBooking")
    public ModelAndView Mybooking(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("signIn");
        List<UserDetail> userdetails = userDetailService.getAllBookingDetails();
        List<UserDetail> MyBookings = new ArrayList<>();
        SignUp user = (SignUp) session.getAttribute("loggedInUser");
        if (session.getAttribute("loggedInUser") == null) {
            return modelAndView;
                
            }
            for(UserDetail detail : userdetails)
            {
                if(detail.getAddarNum()==user.getUserAadhar())
                {
                    MyBookings.add(detail);
                }
            }
            modelAndView.addObject("myBooking", MyBookings);
        modelAndView.setViewName("showLoginUserBooking"); // Thymeleaf template name
        return modelAndView;
    }
  @GetMapping("/SignOut")
  public RedirectView SignOut(HttpSession session) {
      session.removeAttribute("loggedInUser");
      return new RedirectView("/signIn");
  }

  @GetMapping("/admin/loginPage")
  public ModelAndView ShowAdminPage() {
      ModelAndView modelAndView = new ModelAndView("AdminLoginPage");
      return modelAndView;
  }
  
@GetMapping("/admin/landing")
public ModelAndView getAdminPage(HttpSession session)
{
    ModelAndView modelAndView = new ModelAndView("AdminPage");
    if(session.getAttribute("password")!=null)
    {
        return modelAndView;
    }
    modelAndView.setViewName("AdminLoginPage");
    return modelAndView; 
}
@GetMapping("/admin/signOut")
public ModelAndView adminSignOut(HttpSession session)
{
    ModelAndView modelAndView = new ModelAndView("AdminLoginPage");
     session.removeAttribute("password");
    return modelAndView; 
}
    }
 
   

