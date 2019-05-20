package com.jackandphantom.newsapp.NewsApi;

import com.jackandphantom.newsapp.model.NewsApiResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("v2/top-headlines")
    Call<NewsApiResponse> callTopHeadlines(@Query("page") int page,
                          @Query("country") String country, @Query("apiKey") String apiKey);

    
}
