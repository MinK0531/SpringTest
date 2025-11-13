package com.mink.springtest.mvc.repository;

import com.mink.springtest.mvc.domain.Seller;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerRepository {
    public Seller selectSeller();

}
