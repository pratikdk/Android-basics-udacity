package com.example.android.quakereport;

/**
 * Created by Pratik on 12/26/2017.
 */

public class Earthquake {
    private double mMagnitude;
    private String mPlace;
    private long mTimeInMilliseconds;
    private String mQuakeURL;

    public Earthquake(double magnitude, String place, long timeInMilliseconds, String quakeURL) {
        mMagnitude = magnitude;
        mPlace = place;
        mTimeInMilliseconds = timeInMilliseconds;
        mQuakeURL = quakeURL;
    }

    public double getmMagnitude() {
        return mMagnitude;
    }

    public String getmPlace() {
        return mPlace;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public String getmQuakeURL() {
        return mQuakeURL;
    }
}
