package com.mink.springtest.mybatis.service;

import com.mink.springtest.mybatis.domain.RealEstate;
import com.mink.springtest.mybatis.repository.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstateService {

    @Autowired
    private RealEstateRepository realEstateRepository;

    public RealEstate getRealEstate(int id){

        RealEstate realEstate =realEstateRepository.selectRealEstate(id);
        return realEstate;
    }

    // 전달받은 월세보다 낮은 매물 얻어오기

    public List<RealEstate> getRealEstateListByRentPrice(int rentPrice){
        // real_estate 테이블에서 전달받은 월세보다 낮은 행들 조회
        List<RealEstate> realEstateList= realEstateRepository.selectRealEstateListByRentPrice(rentPrice);
        return realEstateList;
    }

    public List<RealEstate> getRealEstateListByAreaPrice(int area, int price){
        List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByAreaPrice(area,price);
        return realEstateList;
    }

    public int createRealEstateByObject(RealEstate realEstate){
        int count = realEstateRepository.insertRealEstateByObject(realEstate);
        return count;
    }
    public int createRealEstate(
            int realtorId
            , String address
            , int area
            , String type
            , int rentPrice
            , int price ){
        int count = realEstateRepository.insertRealEstate(realtorId, address, area, type, price, rentPrice);
        return count;
    }

    //특정id와 매물 정보의 type과 가격을 수정하는 가능
    public int updateRealEstate(int id, String type,int price){
        int count = realEstateRepository.updateRealEstate(id, type, price);
        return count;

    }
    public int deleteRealEstate(int id){
        int count = realEstateRepository.deleteRealEstate(id);
        return count;
    }
}
