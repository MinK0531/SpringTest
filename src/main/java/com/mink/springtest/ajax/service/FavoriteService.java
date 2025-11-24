package com.mink.springtest.ajax.service;

import com.mink.springtest.ajax.domain.Favorite;
import com.mink.springtest.ajax.repository.FavoriteRepository;
import com.mink.springtest.thymeleaf.test04.domain.Weatherhistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public List<Favorite> getFavorite(){
        List<Favorite> favorite = favoriteRepository.selectFavoriteList();
        return favorite;
    }
    public int createFavorit(
            String name
            , String url
    ){
        int count = favoriteRepository.insertFavorite(name, url);
        return count;
    }
    public int deleteFavorit(
            int id
    ){
        int count = favoriteRepository.deleteFavorite(id);
        return count;
    }

    public boolean isDuplicateUrl(String url){
        int count = favoriteRepository.countFavoriteByUrl(url);

        if(count == 0){
            return false;
        }else {
            return true;
        }
    }

}
