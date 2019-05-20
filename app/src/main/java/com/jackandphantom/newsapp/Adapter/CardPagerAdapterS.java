package com.jackandphantom.newsapp.Adapter;

/**
 * Created by KottlandPro TET on 3/3/2018.
 */


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.jackandphantom.newsapp.R;
import com.jackandphantom.newsapp.model.NewsApiArticles;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

// public class CardPagerAdapterS {


public class CardPagerAdapterS extends PagerAdapter implements CardAdapter {

    /*
    * Getting the data list and views so bind the views and data
    * */
    private List<CardView> mViews;
    private List<NewsApiArticles> mData;
    private float mBaseElevation;
    private Context context;

    public interface OnPagerClickListener{
        void onPageClick(String url);
    }

    public CardPagerAdapterS(Context context) {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        this.context = context;
    }
    //Adding more card Item to pager
    public void addCardItemS(NewsApiArticles item) {
        mViews.add(null);
        mData.add(item);
    }

    OnPagerClickListener onPagerClickListener;

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     *
     * Initiate the time and also adding the click listener use to make call on page click
     */
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.news_pager_list, container, false);
        container.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onPagerClickListener != null) {
                    onPagerClickListener.onPageClick(mData.get(position).getUrl());
                }
            }
        });
        bind(mData.get(position), view);
        CardView cardView = (CardView) view.findViewById(R.id.news_card);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        return view;
    }

    public void setOnPagerClickListener(OnPagerClickListener pagerClickListener) {
        onPagerClickListener = pagerClickListener;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }
    /*
    * Bind the data with it's equivalent view
    * */
    private void bind(NewsApiArticles item, View view) {
        TextView titleTextView = (TextView) view.findViewById(R.id.news_headline);
        TextView contentTextView = (TextView) view.findViewById(R.id.news_time);
        ImageView imageView = view.findViewById(R.id.news_image);
        Glide.with(context).load(item.getUrlToImage()).into(imageView);
        Date myDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.setTime(myDate);
        Date time = calendar.getTime();
        SimpleDateFormat outputFmt = new SimpleDateFormat("MMM dd, yyy ");
        String dateAsString = outputFmt.format(time);
        titleTextView.setText(item.getTitle());
        contentTextView.setText(dateAsString);
    }

}

