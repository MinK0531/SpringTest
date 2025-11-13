package com.mink.springtest.mybatis;

import com.mink.springtest.mybatis.domain.RealEstate;
import com.mink.springtest.mybatis.service.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/mybatis/real-estate")
@Controller
public class RealEstateController {

    @Autowired

    private RealEstateService realEstateService;

    @ResponseBody
    @RequestMapping("/select/1")
    public RealEstate  realEstateList(@RequestParam("id") int id){
        RealEstate realEstate = realEstateService.getRealEstate(id);
        return realEstate;
    }
    @ResponseBody
    @RequestMapping("/select/2")
    public List<RealEstate> realEstateByRentPrice(@RequestParam("rent") int rentPrice){
        // 전달받은 월세보다 낮은 매물 얻어오기
        List<RealEstate> realEstateList = realEstateService.getRealEstateListByRentPrice(rentPrice);
        return realEstateList;
    }
    @ResponseBody
    @RequestMapping("/select/3")
    public List<RealEstate> realEstateAreaAndPrice(@RequestParam("area") int area,
                           @RequestParam("price") int price){

        List<RealEstate> realEstateList = realEstateService.getRealEstateListByAreaPrice(area, price);
        return realEstateList;

    }

    @ResponseBody
    @RequestMapping("/insert/1")
    public String addRealEstate(){

//        realtorId : 3
//        address : 푸르지용 리버 303동 1104호
//        area : 89
//        type : 매매
//        price : 100000
        RealEstate realEstate = new RealEstate();
        realEstate.setRealtorId(3);
        realEstate.setAddress("푸르지용 리버 303동 1104호");
        realEstate.setArea(89);
        realEstate.setType("매매");
        realEstate.setPrice(100000);
        int count = realEstateService.createRealEstateByObject(realEstate);
        return "입력 성공 : " + count;
    }

    @ResponseBody
    @RequestMapping("/insert/2")
    public String writeRealEstate(
            @RequestParam("address") String address,
            @RequestParam("area") int area,
            @RequestParam("type") String type,
            @RequestParam("price") int price,
            @RequestParam("rentPrice") int rentPrice
    ){
        int count = realEstateService.createRealEstate(
                address, area, type, price, rentPrice
        );
        return "입력 성공 : " + count;

    }
}
