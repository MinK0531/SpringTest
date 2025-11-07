package com.mink.springtest.lifecycle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/lifecycle/test02")
public class Test02Controller {

    public Map<String, Objects> movies(){
        Map<String,Objects> movie = new HashMap<>();
        
    }

}
