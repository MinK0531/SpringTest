package com.mink.springtest.database.repository;

import com.mink.springtest.database.domain.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreRepository {

    public List<Store> selectStoreList();
}
