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
    public int insertRealEstateByObject(RealEstate realEstate);

    public int insertRealEstate(
            @Param("realtorId") int realtorId
            ,@Param("address") String address
            ,@Param("area") int area
            ,@Param("type") String type
            ,@Param("rentPrice") int rentPrice
            ,@Param("price") int price);
}
