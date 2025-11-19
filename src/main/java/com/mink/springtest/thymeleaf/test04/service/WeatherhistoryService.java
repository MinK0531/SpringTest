package com.mink.springtest.thymeleaf.test04.service;

import com.mink.springtest.database.domain.Store;
import com.mink.springtest.thymeleaf.test04.domain.Weatherhistory;
import com.mink.springtest.thymeleaf.test04.repository.WeatherhistoryRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherhistoryService {
    @Autowired
    private WeatherhistoryRepository weatherhistoryRepository;

    public List<Weatherhistory> getWeatherHistory(){
        List<Weatherhistory> weatherhistory = weatherhistoryRepository.selectWeatherhistoryList();
        return weatherhistory;
    }
    public int createWeatherhistory(
            String date
            , String weather
            ,double temperatures
            ,double precipitation
            ,String microDust
            ,String windSpeed){
        int count = weatherhistoryRepository.insertWeatherhistoryList(date, weather, temperatures, precipitation, microDust, windSpeed);
        return count;
    }


}
