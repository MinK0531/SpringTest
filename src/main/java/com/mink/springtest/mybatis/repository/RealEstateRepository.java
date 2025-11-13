package com.mink.springtest.mybatis.repository;

import com.mink.springtest.mybatis.domain.RealEstate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RealEstateRepository {

    public RealEstate selectRealEstate(@Param("id") int id);

    public List<RealEstate> selectRealEstateListByRentPrice(@Param("rentPrice") int rentPrice);
    public List<RealEstate> selectRealEstateListByAreaPrice(@Param("area") int area,
                                                            @Param("price") int price);


}
