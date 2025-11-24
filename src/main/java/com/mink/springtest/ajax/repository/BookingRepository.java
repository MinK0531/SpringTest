package com.mink.springtest.ajax.repository;

import com.mink.springtest.ajax.domain.Booking;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookingRepository {

    public List<Booking> selectBookingList();
    public int deleteBooking(@Param("id") int id);
    public int insetBooking(Booking booking);
}
