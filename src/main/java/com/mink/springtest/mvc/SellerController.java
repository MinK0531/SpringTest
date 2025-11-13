package com.mink.springtest.mvc;

import com.mink.springtest.mvc.domain.Seller;
import com.mink.springtest.mvc.service.SellerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mvc/seller")
@Controller
public class SellerController {

    private SellerService sellerService;
    @GetMapping("/info")
    public String sellerInfo(Model model){
        Seller seller = sellerService.getSeller();
        model.addAttribute("result",seller);
        return "mvc/sellerInfo";
    }
}
