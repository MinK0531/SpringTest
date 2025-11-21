package com.mink.springtest.ajax;

import com.mink.springtest.ajax.domain.Favorite;
import com.mink.springtest.ajax.service.FavoriteService;
import com.mink.springtest.thymeleaf.test04.domain.Weatherhistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/ajax/favorite")
@Controller
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/info")
    public String FavoriteListInFo(Model model){
        List<Favorite> favoriteList = favoriteService.getFavorite();
        model.addAttribute("favoriteList", favoriteList);
        return "ajax/favoriteInfo";
    }
    @ResponseBody
    @PostMapping ("/add")
    public Map<String,String>   addFavorite(
            @RequestParam("name") String name
            , @RequestParam("url") String url){
        int count = favoriteService.createFavorit(name,url);

        Map<String,String> resultMap =new HashMap<>();

        if (count == 1){
            resultMap.put("result","success");
        }else {
            resultMap.put("result","fail");
        }
        return resultMap;

    }

    @GetMapping("/form")
    public String favoriteForm() {
        return "ajax/favoriteform";
    }

    @ResponseBody
    @GetMapping("duplicate-url")
    public Map<String,Boolean> isDuplicateUrl(@RequestParam("url") String url){
        Map<String,Boolean> resultMap =new HashMap<>();
        if(favoriteService.isDuplicateUrl(url)){
            resultMap.put("isduplicate",true);
        }else {
            resultMap.put("isduplicate",false);
        }
        return resultMap;
    }
}
