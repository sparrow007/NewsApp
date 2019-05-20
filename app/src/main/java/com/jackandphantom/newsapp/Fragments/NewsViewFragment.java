package com.jackandphantom.newsapp.Fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.jackandphantom.newsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsViewFragment extends Fragment {

    private ProgressDialog dialog;
    public NewsViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_view, container, false);
        WebView webView = view.findViewById(R.id.webView);
        String url = getArguments().getString("URL");
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVisibility(View.VISIBLE);
        webView.setWebViewClient(new WebViewClient(getActivity()));
        webView.loadUrl(url);
        dialog = ProgressDialog.show(getActivity(), "Loading", "Please wait...", true);

        return view;
    }

    public class WebViewClient extends android.webkit.WebViewClient
    {
        private boolean loadingFinished = true;
        private boolean redirect = false;


        WebViewClient(Context context) {
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {

            if(!redirect){
                loadingFinished = true;
            }
            if(loadingFinished && !redirect){
                //HIDE LOADING IT HAS FINISHED
                if(dialog.isShowing())
                    dialog.dismiss();

            }

        }
    }


}
