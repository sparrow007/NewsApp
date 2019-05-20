package com.jackandphantom.newsapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsApiResponse {

    @SerializedName("status")
    String status;

    @SerializedName("totalResults")
    int totalResults;

    @SerializedName("articles")
    List<NewsApiArticles> newsApiArticles;

    public NewsApiResponse(){
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsApiArticles> getNewsApiArticles() {
        return newsApiArticles;
    }

    public void setNewsApiArticles(List<NewsApiArticles> newsApiArticles) {
        this.newsApiArticles = newsApiArticles;
    }
}
