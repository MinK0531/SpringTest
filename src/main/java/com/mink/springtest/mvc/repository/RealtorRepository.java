package com.mink.springtest.mvc.repository;

import com.mink.springtest.mvc.domain.Realtor;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RealtorRepository {

    int insertRealtor(Realtor realtor);
}

