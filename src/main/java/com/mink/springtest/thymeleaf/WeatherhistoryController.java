package com.mink.springtest.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherhistoryController {

    @GetMapping("/thymeleaf/weatherhistory")
    public String WeatherhistoryList(){

        return "thymeleaf/weatherhistoryInfo";
    }

}
