package com.mink.springtest.ajax.service;

import com.mink.springtest.ajax.domain.Booking;
import com.mink.springtest.ajax.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getBooking(){
        List<Booking> booking = bookingRepository.selectBookingList();
        return booking;
    }

    public int deleteBooking(int id){
        int count = bookingRepository.deleteBooking(id);
        return count;
    }
    public int createBooking(Booking booking){
        int count = bookingRepository.insertBooking(booking);
        return count;
    }
}
