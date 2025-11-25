package com.mink.springtest.ajax;

import com.mink.springtest.ajax.domain.Booking;
import com.mink.springtest.ajax.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RequestMapping("/ajax/booking")
@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/form")
    public String bookingForm(){
        return "ajax/bookingForm";
    }

    @GetMapping("/info")
    public String bookingInfo(Model model){
        List<Booking> bookingList = bookingService.getBooking();
        model.addAttribute("bookingList", bookingList);
        return "ajax/bookingInfo";
    }

    @GetMapping("/resv")
    public String bookingResv(){
        return "ajax/bookingResv";
    }

    @ResponseBody
    @PostMapping("/delete")
    public Map<String, String> removeBooking(@RequestParam("id") int id) {
        int count = bookingService.deleteBooking(id);
        Map<String, String> resultMap = new HashMap<>();

        if (count == 1) {
            resultMap.put("result", "success");

        } else {
            resultMap.put("result", "fail");
        }
        return resultMap;
    }

    @ResponseBody
    @PostMapping("/add")
    public  Map<String,String> addBooking(@ModelAttribute Booking booking){
        int count = bookingService.createBooking(booking);

        Map<String,String> resultMap =new HashMap<>();

        if (count == 1){
            resultMap.put("result","success");
        }else {
            resultMap.put("result","fail");
        }
        return resultMap;
    }

    @ResponseBody
    @GetMapping("/search")
    public Map<String, Object>  searchBooking(
            @RequestParam("name") String name
            ,@RequestParam("phoneNumber") String phoneNumber) {

        Booking booking = bookingService.getBooking(name, phoneNumber);

        Map<String, Object> resultMap = new HashMap<>();


//        resultMap.put("name", booking.getName());
//        resultMap.put("date", booking.getDate());
//        resultMap.put("day", booking.getDay());
//        resultMap.put("headCount", booking.getHeadCount());
//        resultMap.put("state", booking.getState());

        if (booking != null){
            resultMap.put("result", "success");
            resultMap.put("booking", booking);
        }else {
            resultMap.put("result","fail");
        }
        return resultMap;
    }
}
