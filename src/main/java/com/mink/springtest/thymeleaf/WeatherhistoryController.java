package com.mink.springtest.thymeleaf;

import com.mink.springtest.mvc.domain.Realtor;
import com.mink.springtest.thymeleaf.test04.domain.Weatherhistory;
import com.mink.springtest.thymeleaf.test04.service.WeatherhistoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RequestMapping("/thymeleaf/weatherhistory")
@Controller
public class WeatherhistoryController {

    @Autowired
    private WeatherhistoryService weatherhistoryService;

    @GetMapping("/add")
    public String addWeather(@ModelAttribute Weatherhistory weatherhistory) {

//            @RequestParam("date") @DateTimeFormat(pattern="yyyy년 M월 d일") LocalDate date  // 2025년 11월 20일
//        , @RequestParam("weather") String weather
//        , @RequestParam("temperatures") double temperatures
//        , @RequestParam("precipitation") double precipitation
//        , @RequestParam("microDust") String microDust
//        , @RequestParam("windSpeed") double windSpeed) {


//        int count = weatherService.createWeather(date, weather, temperatures, precipitation, microDust, windSpeed);

        int count = weatherhistoryService.createWeatherhistoryByObject(weatherhistory);

        return "redirect:/thymeleaf/weatherhistory/info";

    }

    @GetMapping("/form")
    public String WeatherhistoryListForm(){

        return "thymeleaf/weatherhistoryform";
    }



    @GetMapping("/info")
    public String WeatherhistoryListInFo(Model model){
        List<Weatherhistory> weatherhistoryList = weatherhistoryService.getWeatherHistory();
        model.addAttribute("weatherhistoryList", weatherhistoryList);
        return "thymeleaf/weatherhistoryInfo";
    }
}
