package com.mink.springtest.database.service;

import com.mink.springtest.database.domain.Store;
import com.mink.springtest.database.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public List<Store>  getStoreList(){
        List<Store> storeList = storeRepository.selectStoreList();

        return storeList;

    }
}
