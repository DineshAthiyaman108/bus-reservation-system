package com.BusReservation.Project.HtmlController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.BusReservation.Project.BusDetail.BusDetails;
import com.BusReservation.Project.Services.BusDetailService;

import jakarta.servlet.http.HttpSession;

@RestController
public class HtmlController {

    @Autowired
    private BusDetailService busDetailServiceservice;

    @GetMapping("/index")
    public  ModelAndView showBookingPage( HttpSession session)
     {
        ModelAndView modelAndView = new ModelAndView("signIn");
        if (session.getAttribute("loggedInUser") == null) {
        
            return modelAndView;
        }
       
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @GetMapping("/signIn")
    public  ModelAndView showLoginPage()
     {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SignIn");
        return modelAndView;
    }
    @GetMapping("/SignUp")
    public  ModelAndView showSingUpPage()
     {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SignUp");
        return modelAndView;
    }
    @GetMapping("/newUserBooking")
    public  ModelAndView showNewBookingPage(HttpSession session)
     {
        ModelAndView modelAndView = new ModelAndView("signIn");
        if (session.getAttribute("loggedInUser") == null) {
        
            return modelAndView ;
        }
       
        modelAndView.setViewName("UserDetail");
        return modelAndView;
    }
    @GetMapping("/userTicketCancel")
    public  ModelAndView showCancleBookingPage(HttpSession session)
     {
        
        ModelAndView modelAndView = new ModelAndView("signIn");
        if (session.getAttribute("loggedInUser") == null) {
        
            return modelAndView ;
        }
        modelAndView.setViewName("TicketCancle"); 
        return modelAndView;
    }
    @GetMapping("/newBus")
    public  ModelAndView showNewBusPage(HttpSession session)
    {
     
        ModelAndView modelAndView = new ModelAndView("signIn");
        if (session.getAttribute("loggedInUser") == null) {
        
            return modelAndView ;
        }
        modelAndView.setViewName("BusDetail"); 
        return modelAndView;
    }
    @GetMapping("/getBusesDetails")
    public  ModelAndView showAllBusPage(HttpSession session)
    {
       
        ModelAndView modelAndView = new ModelAndView("signIn");
        if (session.getAttribute("loggedInUser") == null) {
        
            return modelAndView ;
        }
        modelAndView.setViewName("ShowBusDetail"); 
        return modelAndView;
    }
    @PostMapping("/admin")
    public RedirectView  showModelViewPage(@RequestParam("adminName") String adminName,
    @RequestParam("adminPassword") String adminPassword, HttpSession session )
    {
      
        session.setAttribute("password", adminPassword);
        if(adminName.equals("dinesh") && adminPassword.equals("Azarnanee008@"))
        {
        return  new RedirectView("/admin/landing");
        }
                
        return  new RedirectView("/admin/loginPage");  
    }
    @GetMapping("/MainLogin")
    public ModelAndView showMainLoginPage(HttpSession session)
    {
        ModelAndView modelAndView = new ModelAndView("signIn");
        if (session.getAttribute("loggedInUser") == null) {
        
            return modelAndView ;
        }
        modelAndView.setViewName("MainLanding"); 
        return modelAndView;
    }
    @GetMapping("/ticketCancleSuccess")
    public ModelAndView showTicketCancelPage(HttpSession session)
    {
        ModelAndView modelAndView = new ModelAndView("signIn");
        if (session.getAttribute("loggedInUser") == null) {
        
            return modelAndView ;
        }
        modelAndView.setViewName("TicketCancellingSuccess"); 
        return modelAndView;
    }
    @GetMapping("/BookingSuccess")
    public ModelAndView BookingSuccess(HttpSession session)
    {
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("BookingSuccessPage"); 
        return modelAndView;
    }
    @GetMapping("/admin/busdetail")
    public ModelAndView getAdminBusDetails(HttpSession session)
    {
        ModelAndView modelAndView = new ModelAndView("AdminLoginPage");
        if(session.getAttribute("password")==null)
    {
        return modelAndView;
    }
           List<BusDetails> myList = busDetailServiceservice.getAllBusDetails();
        modelAndView.addObject("myList", myList);
        modelAndView.setViewName("adminBusDetail"); 
        return modelAndView;
    }
    @GetMapping("/BookingUnSuccess")
    public ModelAndView BookingUnSuccess(HttpSession session)
    {
        ModelAndView modelAndView = new ModelAndView("signIn");
        if (session.getAttribute("loggedInUser") == null) {
        
            return modelAndView ;
        }
        modelAndView.setViewName("BookingUnSuccess"); 
        return modelAndView;
    }
 
    @GetMapping("/admin/newBus")
public ModelAndView getAdminBusDetail(HttpSession session)
{
    ModelAndView modelAndView = new ModelAndView("BusDetail");
    if(session.getAttribute("password")!=null)
    {
        return modelAndView;
    }
    modelAndView.setViewName("AdminLoginPage");
    return modelAndView; 
}

@GetMapping("/ticketCancleUnSuccess")
public ModelAndView showTicketCancelUnseccessPage(HttpSession session)
{
    ModelAndView modelAndView = new ModelAndView("signIn");
    if (session.getAttribute("loggedInUser") == null) {
    
        return modelAndView ;
    }
    modelAndView.setViewName("TicketUnSuccessfull"); 
    return modelAndView;
}
}
