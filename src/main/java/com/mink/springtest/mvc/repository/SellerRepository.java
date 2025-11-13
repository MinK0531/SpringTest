package com.mink.springtest.mvc.repository;

import com.mink.springtest.mvc.domain.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SellerRepository {
    public Seller selectSeller();
    public int insertSeller(
            @Param("nickName") String nickName
            , @Param("temperature") double temperature
            , @Param("profileImage") String profileImage);
    public Seller selectSellerById(@Param("id") int id);

}

