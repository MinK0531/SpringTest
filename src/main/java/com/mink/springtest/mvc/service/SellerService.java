package com.mink.springtest.mvc.service;

import com.mink.springtest.mvc.domain.Seller;
import com.mink.springtest.mvc.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {


    @Autowired
    private SellerRepository sellerRepository;

    public Seller getSeller(){
        Seller seller = sellerRepository.selectSeller();
        return seller;
    }

    public int createSeller(
            String nickName
            , double temperature
            , String profileImage){
        int count = sellerRepository.insertSeller(nickName, temperature, profileImage);
        return count;
    }

    public Seller getSellerById(int id){

        Seller seller = sellerRepository.selectSellerById(id);
        return seller;
    }
}
