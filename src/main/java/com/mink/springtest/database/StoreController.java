package com.mink.springtest.database;

import com.mink.springtest.database.domain.Store;
import com.mink.springtest.database.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StoreController {

    @Autowired
    private StoreService storeService;

    @ResponseBody
    @RequestMapping("/db/store/list")
    public List<Store> StoreList(){

        List<Store> storeList = storeService.getStoreList();
        return storeList;

    }
}
