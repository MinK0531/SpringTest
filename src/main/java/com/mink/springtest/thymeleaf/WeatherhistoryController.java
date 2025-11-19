package com.mink.springtest.thymeleaf;

import com.mink.springtest.mvc.domain.Realtor;
import com.mink.springtest.thymeleaf.test04.domain.Weatherhistory;
import com.mink.springtest.thymeleaf.test04.service.WeatherhistoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/thymeleaf/weatherhistory")
@Controller
public class WeatherhistoryController {

    @Autowired
    private WeatherhistoryService weatherhistoryService;

    @PostMapping("/add")
    public String addWeatherhistoryList(
            @RequestParam("date") String date
            , @RequestParam("weather") String weather
            , @RequestParam("temperatures") double temperatures
            , @RequestParam("precipitation") double precipitation
            , @RequestParam("microDust") String microDust
            , @RequestParam("windSpeed") String windSpeed
            ,Model model){
        List<Weatherhistory> weatherhistoryList = weatherhistoryService.getWeatherHistory();
        model.addAttribute("weatherhistoryList", weatherhistoryList);

        int count = weatherhistoryService.createWeatherhistory(date, weather, temperatures, precipitation, microDust, windSpeed);
        return "입력 결과 : " + count;
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
