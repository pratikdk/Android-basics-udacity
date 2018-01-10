package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Pratik on 11/17/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceID;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceID) {
        // Since this is a customAdapter the resource template isn't needed to be supplied to super()
        // Custom implementation uses getView method to provide custom recycle view
        super(context, 0, words);
        this.mColorResourceID = colorResourceID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        //
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView miWokTextView = (TextView) listItemView.findViewById(R.id.miwok_text);
        miWokTextView.setText(currentWord.getMiWokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.english_text);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView resourceImageView = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            resourceImageView.setImageResource(currentWord.getImageResouceId());
            resourceImageView.setVisibility(View.VISIBLE);
        } else {
            resourceImageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
