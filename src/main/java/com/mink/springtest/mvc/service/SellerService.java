package com.mink.springtest.mvc.service;

import com.mink.springtest.mvc.domain.Seller;
import com.mink.springtest.mvc.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {


    @Autowired
    private SellerRepository sellerRepository;
    public Seller getSeller(){
        Seller seller = sellerRepository.selectSeller();
        return seller;
    }
}
