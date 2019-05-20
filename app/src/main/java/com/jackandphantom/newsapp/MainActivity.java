package com.jackandphantom.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jackandphantom.newsapp.NewsApi.ApiCall.NewsApiCall;
import com.jackandphantom.newsapp.NewsApi.NewsApi;
import com.jackandphantom.newsapp.model.NewsApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.jackandphantom.newsapp.Utils.ConstantsUtil.COUNTRY;
import static com.jackandphantom.newsapp.Utils.ConstantsUtil.PAGENO;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = NewsApiCall.getRetrofitInstance();
        NewsApi api = retrofit.create(NewsApi.class);
        api.callTopHeadlines(PAGENO, COUNTRY, getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<NewsApiResponse>() {
                    @Override
                    public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {
                         if (response.isSuccessful()) {
                             NewsApiResponse newsApiResponse = response.body();
                             Log.e("MY TAG", "LIST IS = "+newsApiResponse.getNewsApiArticles().size());
                         }
                    }

                    @Override
                    public void onFailure(Call<NewsApiResponse> call, Throwable t) {
                           Log.e("MY TAG", "ERROR IN MESSAGE= "+t.getMessage());
                    }
                });
    }
}
