package com.jackandphantom.newsapp.Fragments;


import android.content.Context;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jackandphantom.newsapp.Adapter.CardPagerAdapterS;
import com.jackandphantom.newsapp.Adapter.NewsDataAdapter;
import com.jackandphantom.newsapp.NewsApi.ApiCall.NewsApiCall;
import com.jackandphantom.newsapp.NewsApi.NewsApi;
import com.jackandphantom.newsapp.R;
import com.jackandphantom.newsapp.Utils.ShadowTransformer;
import com.jackandphantom.newsapp.database.AppDatabase;
import com.jackandphantom.newsapp.model.NewsApiArticles;
import com.jackandphantom.newsapp.model.NewsApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.jackandphantom.newsapp.Utils.ConstantsUtil.COUNTRY;
import static com.jackandphantom.newsapp.Utils.ConstantsUtil.PAGENO;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsListFragment extends Fragment implements NewsDataAdapter.OnBookmarkClickListener, NewsDataAdapter.OnNewsClickListener, CardPagerAdapterS.OnPagerClickListener {

    private ViewPager mViewPager;

    private CardPagerAdapterS mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private RecyclerView mRecyclerView;

    private Context context;
    public NewsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        context = getActivity();


        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mCardAdapter = new CardPagerAdapterS(context);
        mRecyclerView = view.findViewById(R.id.news_list_recycler);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(15));

        Retrofit retrofit = NewsApiCall.getRetrofitInstance();
        NewsApi api = retrofit.create(NewsApi.class);
        api.callTopHeadlines(PAGENO, COUNTRY, getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<NewsApiResponse>() {
                    @Override
                    public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {
                        if (response.isSuccessful()) {
                            NewsApiResponse newsApiResponse = response.body();
                            for (int i = 0; i < 4; i++) {
                                mCardAdapter.addCardItemS(newsApiResponse.getNewsApiArticles().get(i));
                            }
                            mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
                            mViewPager.setAdapter(mCardAdapter);
                            mViewPager.setPageTransformer(false, mCardShadowTransformer);
                            mViewPager.setOffscreenPageLimit(3);
                            NewsDataAdapter newsDataAdapter = new NewsDataAdapter(context, newsApiResponse.getNewsApiArticles());
                            newsDataAdapter.setOnBookmarkClickListener(NewsListFragment.this);
                            newsDataAdapter.setOnNewsClickListener(NewsListFragment.this);
                            mCardAdapter.setOnPagerClickListener(NewsListFragment.this);
                            mRecyclerView.setAdapter(newsDataAdapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<NewsApiResponse> call, Throwable t) {
                        Log.e("MY TAG", "ERROR IN MESSAGE= " + t.getMessage());
                    }
                });

        return view;
    }

   /*
   * Adding the news to database , this method contain the background task which is inserting
   * the data into the database.
   * */
    @Override
    public void onBookmarkClick(final NewsApiArticles newsApiArticles) {
        final AppDatabase appDatabase =  AppDatabase.getAppDatabase(getActivity());
        new  AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase.userDao().insertAll(newsApiArticles);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getActivity(), "Data has been Saved", Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    @Override
    public void onNewsClick(String url) {
        callWebView(url);
    }

    //calling the next screen when news clicked
    @Override
    public void onPageClick(String url) {
        callWebView(url);
    }

    private void callWebView(String url) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Bundle b = new Bundle();
        b.putString("URL", url);
        NewsViewFragment newsViewFragment = new NewsViewFragment();
        newsViewFragment.setArguments(b);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.frame_layout, newsViewFragment).commit();

    }
}
/*
* Adding more space in recyclerview
* */
 class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private final int verticalSpaceHeight;

    public VerticalSpaceItemDecoration(int verticalSpaceHeight) {
        this.verticalSpaceHeight = verticalSpaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.bottom = verticalSpaceHeight;
    }
}
