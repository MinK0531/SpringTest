package com.mink.springtest.mvc;

import com.mink.springtest.mvc.domain.Seller;
import com.mink.springtest.mvc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/mvc/seller")
@Controller
public class SellerController {

    @Autowired
    private SellerService sellerService;


    @ResponseBody
    @PostMapping("/add")
    public String addSeller(
            @RequestParam("nickName") String nickName
            , @RequestParam("temperature") double temperature
            , @RequestParam("profileImage") String profileImage){

        int count = sellerService.createSeller(nickName, temperature, profileImage);
        return "입력 결과 : " + count;
    }
    @GetMapping("/form")
    public String sellerForm(){

        return "mvc/sellerForm";
    }
    @GetMapping("/info")
    public String sellerInfo(@RequestParam(required = false) Integer id, Model model) {
        Seller seller;

        if (id != null) {
            seller = sellerService.getSellerById(id);
        } else {
            seller = sellerService.getSeller();
        }

        model.addAttribute("result", seller);
        return "mvc/sellerInfo";
    }


}
