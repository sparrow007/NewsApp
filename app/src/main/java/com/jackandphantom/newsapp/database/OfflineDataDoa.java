package com.jackandphantom.newsapp.database;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.jackandphantom.newsapp.model.NewsApiArticles;

import java.util.List;

//Interface to making the database call
//only has two method for now
@Dao
public interface OfflineDataDoa {

    @Query("SELECT * FROM NewsApiArticles")
    List<NewsApiArticles> getAll();

    @Insert
    void insertAll(NewsApiArticles offlineData);

}
