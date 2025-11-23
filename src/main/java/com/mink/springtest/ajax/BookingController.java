package com.mink.springtest.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ajax/booking")
@Controller
public class BookingController {

    @GetMapping("/form")
    public String bookingForm(){
        return "ajax/bookingForm";
    }

    @GetMapping("/info")
    public String bookingInfo(){
        return "ajax/bookingInfo";
    }

    @GetMapping("/resv")
    public String bookingResv(){
        return "ajax/bookingResv";
    }
}
