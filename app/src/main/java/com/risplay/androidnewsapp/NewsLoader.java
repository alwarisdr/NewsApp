package com.risplay.androidnewsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by alwaris on 4/11/17.
 */

public class NewsLoader extends AsyncTaskLoader {

    /** Tag for log messages */
    private static final String LOG_TAG = NewsLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link NewsLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG,"TEST:onStartLoading() called...");
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        Log.i(LOG_TAG,"TEST:loadInBackground() called...");
        if (mUrl == null) {
            return null;

        }

        List<News> thenews = QueryUtils.fetchNewsData(mUrl);
        Log.i(LOG_TAG,"TEST:fetchNewsData() complete...");
        return thenews;

    }

}
