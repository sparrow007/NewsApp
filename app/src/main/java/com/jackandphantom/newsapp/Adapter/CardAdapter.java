package com.jackandphantom.newsapp.Adapter;


import android.support.v7.widget.CardView;
//This is utils for the viewpager adapter
public interface CardAdapter {

    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}
