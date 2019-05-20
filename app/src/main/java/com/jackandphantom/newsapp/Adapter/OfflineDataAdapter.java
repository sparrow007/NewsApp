package com.jackandphantom.newsapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jackandphantom.newsapp.R;
import com.jackandphantom.newsapp.model.NewsApiArticles;

import java.util.List;

public class OfflineDataAdapter extends RecyclerView.Adapter<OfflineDataAdapter.ViewHolder> {

    private List<NewsApiArticles> newsData;
    private LayoutInflater inflater;
    private Context mContext;

    public OfflineDataAdapter(Context context, List<NewsApiArticles>data) {
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
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        NewsApiArticles newsApiArticles = newsData.get(position);
        viewHolder.titleText.setText(newsApiArticles.getTitle());
        viewHolder.timeText.setText(newsApiArticles.getPublishedAt());
        Glide.with(mContext).load(newsApiArticles.getUrlToImage()).into(viewHolder.newsCover);
    }

    @Override
    public int getItemCount() {
        return newsData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleText, timeText;
        ImageView newsCover , bookmark;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            timeText = itemView.findViewById(R.id.news_time);
            titleText = itemView.findViewById(R.id.news_title);
            newsCover = itemView.findViewById(R.id.news_cover_image);
            bookmark = itemView.findViewById(R.id.news_bookmark);
        }
    }
}
