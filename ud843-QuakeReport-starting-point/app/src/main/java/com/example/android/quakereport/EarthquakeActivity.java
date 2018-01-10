/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.app.LoaderManager;
import android.content.AsyncQueryHandler;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ExpandedMenuView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Earthquake>> {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    /**
     * URL for earthquake data from USGS dataset
     */
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=5&limit=30";

    private EarthquakeAdapter mAdapter;
    private TextView emptyTextView;
    private View loadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);
        Log.e(LOG_TAG, "Test: EarthquakeActivity onCreate() called.");

        loadingIndicator =  findViewById(R.id.loading_indicator);

        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        Boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        // Create a fake list of earthquake locations.
//        ArrayList<Earthquake> earthquakes = new ArrayList<>();
//        earthquakes.add("San Francisco");
//        earthquakes.add("London");
//        earthquakes.add("Tokyo");
//        earthquakes.add("Mexico City");
//        earthquakes.add("Moscow");
//        earthquakes.add("Rio de Janeiro");
//        earthquakes.add("Paris");

//        earthquakes.add(new Earthquake(5.6, "San Francisco", "Nov 3, 2015"));
//        earthquakes.add(new Earthquake(4.3, "London", "Dec 15, 2016"));
//        earthquakes.add(new Earthquake(5.0, "Tokyo", "Jan 13, 2016"));
//        earthquakes.add(new Earthquake(7.3, "Mexico City", "Feb 22, 2016"));
//        earthquakes.add(new Earthquake(3.4, "Moscow", "Mar 10, 2016"));
//        earthquakes.add(new Earthquake(7.7, "Rio de Janeiro", "Apr 26, 2016"));
//        earthquakes.add(new Earthquake(8.1, "Paris", "Jun 7, 2016"));


        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this, android.R.layout.simple_list_item_1, earthquakes);
//        final EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);
        mAdapter = new EarthquakeAdapter(this, new ArrayList<Earthquake>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(mAdapter);

        emptyTextView = (TextView) findViewById(R.id.empty_view);
        earthquakeListView.setEmptyView(emptyTextView);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Earthquake currentEarthquake = mAdapter.getItem(position);
                Uri earthquakeUri = Uri.parse(currentEarthquake.getmQuakeURL());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);
                startActivity(websiteIntent);
            }
        });

//        EarthquakeAsyncTask task = new EarthquakeAsyncTask();
//        task.execute(USGS_REQUEST_URL);
        if (isConnected) {
            Log.e(LOG_TAG, "Test: EarthquakeActivity initLoader() called.");
            getLoaderManager().initLoader(1, null, this);
        } else {
            loadingIndicator.setVisibility(View.GONE);
            emptyTextView.setText("No internet connection.");
        }
    }

    @Override
    public Loader<List<Earthquake>> onCreateLoader(int i, Bundle bundle) {
        Log.e(LOG_TAG, "Test: EarthquakeActivity onCreateLoader() called.");

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String minMagnitude = sharedPrefs.getString(
                getString(R.string.settings_min_magnitude_key),
                getString(R.string.settings_min_magnitude_default)
        );
        Log.e(LOG_TAG, "Test: EarthquakeActivity minMagnitude value = " + minMagnitude);

        String orderBy = sharedPrefs.getString(
                getString(R.string.settings_order_by_key),
                getString(R.string.settings_order_by_default));


        String limit = sharedPrefs.getString(
                getString(R.string.settings_limit_key),
                getString(R.string.settings_limit_default)
        );

        Uri baseUri = Uri.parse(USGS_REQUEST_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        uriBuilder.appendQueryParameter("format", "geojson");
        uriBuilder.appendQueryParameter("limit", limit); // default 10
        uriBuilder.appendQueryParameter("minmag", minMagnitude);
        uriBuilder.appendQueryParameter("orderby", orderBy);

        return new EarthquakeLoader(this, uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<Earthquake>> loader, List<Earthquake> earthquakes) {
        loadingIndicator.setVisibility(View.GONE);

        emptyTextView.setText("No earthquakes found.");

        Log.e(LOG_TAG, "Test: EarthquakeActivity onLoadFinished() called.");
        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (earthquakes != null && !earthquakes.isEmpty()) {
            mAdapter.addAll(earthquakes);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Earthquake>> loader) {
        Log.e(LOG_TAG, "Test: EarthquakeActivity onLoaderReset() called.");
        mAdapter.clear();
    }

//    private class EarthquakeAsyncTask extends AsyncTask<String, Void, List<Earthquake>> {
//        @Override
//        protected List<Earthquake> doInBackground(String... urls) {
//            if (urls.length < 1 || urls[0] == null) {
//                return null;
//            }
//
//            List<Earthquake> earthquakes = QueryUtils.fetchEarthquakequakeDataList(urls[0]);
//            return earthquakes;
//        }
//
//        @Override
//        protected void onPostExecute(List<Earthquake> earthquakes) {
//            // Clear the adapter of previous earthquake data
//            mAdapter.clear();
//
//            // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
//            // data set. This will trigger the ListView to update.
//            if (earthquakes != null || !earthquakes.isEmpty()) {
//                mAdapter.addAll(earthquakes);
//            }
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }

        return super.onOptionsItemSelected(menuItem);
    }
}
