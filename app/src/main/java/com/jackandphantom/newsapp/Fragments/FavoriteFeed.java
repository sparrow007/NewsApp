package com.jackandphantom.newsapp.Fragments;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jackandphantom.newsapp.Adapter.OfflineDataAdapter;
import com.jackandphantom.newsapp.R;
import com.jackandphantom.newsapp.database.AppDatabase;
import com.jackandphantom.newsapp.model.NewsApiArticles;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFeed extends Fragment {

    private RecyclerView recyclerView;
    private AppDatabase appDatabase;
    private List<NewsApiArticles> offlineData;
    private Context context;
    //favorite_feed_recyclerview
    public FavoriteFeed() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_favorite_feed, container, false);
        recyclerView = view.findViewById(R.id.favorite_feed_recyclerview);
        context = getActivity();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        appDatabase  = AppDatabase.getAppDatabase(getActivity());
        new Work().execute();
        return view;
    }
 /*
 * This background task for getting the data from the databse and show on the recyclerview
 * */
    class Work extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            offlineData = appDatabase.userDao().getAll();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (offlineData.size() <= 0) {
                Toast.makeText(context, "No saved data", Toast.LENGTH_SHORT).show();
                return;
            }
            OfflineDataAdapter newsDataAdapter = new OfflineDataAdapter(context, offlineData);
            recyclerView.setAdapter(newsDataAdapter);
        }
    }

}
