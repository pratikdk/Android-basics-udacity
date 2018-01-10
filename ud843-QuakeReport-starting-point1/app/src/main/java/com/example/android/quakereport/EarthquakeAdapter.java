package com.example.android.quakereport;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Pratik on 12/26/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        final Earthquake currentEarthquake = getItem(position);

        DecimalFormat magnitudeFormatter = new DecimalFormat("0.0");
        String magnitudeValue = magnitudeFormatter.format(currentEarthquake.getmMagnitude());

        TextView quakeMagnitude = (TextView) listItemView.findViewById(R.id.magnitude);
//        quakeMagnitude.setText(String.valueOf(currentEarthquake.getmMagnitude()));

        GradientDrawable magnitudeCircle = (GradientDrawable) quakeMagnitude.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMagnitude());

        quakeMagnitude.setText(magnitudeValue);
        magnitudeCircle.setColor(magnitudeColor);

        String quakePlace = currentEarthquake.getmPlace();

        String offsetLocationValue = "";
        String primaryLocationValue = "";
        if (!quakePlace.contains(",")) {
            offsetLocationValue = "Near the";
            primaryLocationValue = quakePlace;
        } else {
            String[] placeArray = quakePlace.split(",");
            offsetLocationValue = placeArray[0];
            primaryLocationValue = placeArray[1];
        }

        TextView offsetLocationView = (TextView) listItemView.findViewById(R.id.offset_location);
        offsetLocationView.setText(offsetLocationValue);
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocationValue);

        long timeInMillis = currentEarthquake.getTimeInMilliseconds();
        Date dateObject = new Date(timeInMillis);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("LLL dd, yyyy");
        String quakeDateValue = dateFormatter.format(dateObject);
        SimpleDateFormat timeFormatter = new SimpleDateFormat(("h:mm a"));
        String quakeTimeValue = timeFormatter.format(dateObject);

        TextView quakeDate = (TextView) listItemView.findViewById(R.id.date);
        quakeDate.setText(quakeDateValue);

        TextView quakeTime = (TextView) listItemView.findViewById(R.id.time);
        quakeTime.setText(quakeTimeValue);

//        listItemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(currentEarthquake.getmQuakeURL()));
//                getContext().startActivity(i);
//            }
//        });

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceID;
        int magnitudeFloor = (int) Math.floor(magnitude);

        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceID = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceID = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceID = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceID = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceID = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceID = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceID = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceID = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceID = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceID = R.color.magnitude10plus;
                break;

        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceID);
    }
}
