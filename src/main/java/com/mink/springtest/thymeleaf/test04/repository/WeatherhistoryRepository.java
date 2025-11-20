package com.mink.springtest.thymeleaf.test04.repository;

import com.mink.springtest.thymeleaf.test04.domain.Weatherhistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface WeatherhistoryRepository {
    public List<Weatherhistory> selectWeatherhistoryList();
    public int insertWeatherhistoryList(
            @Param("date") LocalDate date
            , @Param("weather") String weather
            , @Param("temperatures") double temperatures
            , @Param("precipitation") double precipitation
            , @Param("microDust") String microDust
            , @Param("windSpeed") double windSpeed);

    public  int insertWeatherhistoryByObject (Weatherhistory weatherhistory);

}
