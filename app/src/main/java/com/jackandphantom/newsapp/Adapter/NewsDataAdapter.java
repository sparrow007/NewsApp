package com.jackandphantom.newsapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jackandphantom.newsapp.R;
import com.jackandphantom.newsapp.model.NewsApiArticles;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class NewsDataAdapter extends RecyclerView.Adapter<NewsDataAdapter.ViewHolder> {

    private List<NewsApiArticles> newsData;
    private LayoutInflater inflater;
    private Context mContext;

    /*
    * This listener use to make call the method onNewsClick when user click on the news
    * and send to next screen
    * */
    public interface OnNewsClickListener {
         void onNewsClick(String url);
     }

     //When user click on the bookmark icon then it get called and adding the news to database
    public interface OnBookmarkClickListener {
         void onBookmarkClick(NewsApiArticles newsApiArticles);
     }

     OnNewsClickListener onNewsClickListener;
     OnBookmarkClickListener onBookmarkClickListener;

    public NewsDataAdapter(Context context, List<NewsApiArticles>data) {
        inflater = LayoutInflater.from(context);
        this.newsData = data;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.headline_list_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        int position = i + 4;
        if (position >= 20)
            return;
        NewsApiArticles newsApiArticles = newsData.get(position);
        viewHolder.titleText.setText(newsApiArticles.getTitle());
        Date myDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.setTime(myDate);
        Date time = calendar.getTime();
        SimpleDateFormat outputFmt = new SimpleDateFormat("MMM dd, yyy ");
        String dateAsString = outputFmt.format(time);
        viewHolder.timeText.setText(dateAsString);
        Glide.with(mContext).load(newsApiArticles.getUrlToImage()).into(viewHolder.newsCover);
    }

    @Override
    public int getItemCount() {
        return newsData.size()-4;
    }

    public void setOnNewsClickListener(OnNewsClickListener onNewsClickListener) {
        this.onNewsClickListener = onNewsClickListener;
    }

    public void setOnBookmarkClickListener(OnBookmarkClickListener onBookmarkClickListener) {
        this.onBookmarkClickListener = onBookmarkClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleText, timeText;
        ImageView newsCover , bookmark;

         ViewHolder(@NonNull View itemView) {
            super(itemView);

            timeText = itemView.findViewById(R.id.news_time);
            titleText = itemView.findViewById(R.id.news_title);
            newsCover = itemView.findViewById(R.id.news_cover_image);
            bookmark = itemView.findViewById(R.id.news_bookmark);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onNewsClickListener != null) {
                        int position = getAdapterPosition() + 4;
                        if (position >= 20)
                            return;
                        onNewsClickListener.onNewsClick(newsData.get(position).getUrl());
                    }
                }
            });

            bookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    bookmark.setImageResource(R.drawable.ic_bookmark_color_24dp);
                    Toast.makeText(mContext, "Added to my feed", Toast.LENGTH_SHORT).show();
                    if (onBookmarkClickListener != null) {
                        int position = getAdapterPosition() + 4;
                        if (position >= 20)
                            return;
                        onBookmarkClickListener.onBookmarkClick(newsData.get(position));
                    }
                }
            });
        }
    }
}
