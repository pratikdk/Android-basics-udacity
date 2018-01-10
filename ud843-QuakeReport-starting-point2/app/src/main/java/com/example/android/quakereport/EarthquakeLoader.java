package com.example.android.quakereport;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by Pratik on 1/7/2018.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    public static final String LOG_TAG = EarthquakeLoader.class.getName();

    private String mRequestURL;
    public EarthquakeLoader(Context context, String requestURL) {
        super(context);
        mRequestURL = requestURL;
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.e(LOG_TAG, "Test: EarthquakeLoader loadInBackground() called.");
        if (mRequestURL == null) {
            return null;
        }

        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakequakeDataList(mRequestURL);
        return earthquakes;
    }

    @Override
    protected void onStartLoading() {
        Log.e(LOG_TAG, "Test: EarthquakeLoader onStartLoading() called.");
        forceLoad();
    }
}
