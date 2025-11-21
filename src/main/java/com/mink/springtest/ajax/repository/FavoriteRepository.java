package com.mink.springtest.ajax.repository;

import com.mink.springtest.ajax.domain.Favorite;
import com.mink.springtest.thymeleaf.test04.domain.Weatherhistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FavoriteRepository {
    public List<Favorite> selectFavoriteList();

    public int insertFavorite(
            @Param("name") String name,
            @Param("url") String url
    );
}
