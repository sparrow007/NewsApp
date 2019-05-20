package com.jackandphantom.newsapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;


@Entity
public class NewsApiArticles {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @SerializedName("title")
    @ColumnInfo(name = "title")
    String title;

    @SerializedName("description")
    @ColumnInfo(name = "description")
    String description;

    @SerializedName("urlToImage")
    @ColumnInfo(name = "urlToImage")
    String urlToImage;

    @SerializedName("url")
    @ColumnInfo(name = "url")
    String url;

    @SerializedName("publishedAt")
    @ColumnInfo(name = "publishedAt")
    String publishedAt;

    public NewsApiArticles(){

    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
