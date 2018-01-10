package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
//
//    private MediaPlayer mediaPlayer;
//    private AudioManager audioManager;
//
//    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
//        @Override
//        public void onCompletion(MediaPlayer mp) {
//            releaseMediaPlayer();
//        }
//    };
//
//    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
//        @Override
//        public void onAudioFocusChange(int focusChange) {
//            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
//                mediaPlayer.pause();
//                mediaPlayer.seekTo(0);
//            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
//                mediaPlayer.start();
//            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
//                releaseMediaPlayer();
//            }
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ColorsFragment()).commit();

//        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
//
//        final ArrayList<Word> words = new ArrayList<Word>();
//        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red,  R.raw.song));
//        words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow,
//                R.raw.color_mustard_yellow));
//        words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow,
//                R.raw.color_dusty_yellow));
//        words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
//        words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
//        words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
//        words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
//        words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
//
//        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);
//
//        ListView listView = (ListView) findViewById(R.id.list);
//
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                releaseMediaPlayer();
//
//                Word selectedWord = words.get(position);
//                int wordAudioID = selectedWord.getmAudioResourceID();
//
//                int result = audioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
//
//                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
//                    // since we need to access the context from an inner class we use the dot operator on class to access the context
//                    mediaPlayer = MediaPlayer.create(ColorsActivity.this, wordAudioID);
//                    mediaPlayer.start();
//
//                    mediaPlayer.setOnCompletionListener(mCompletionListener);
//                }
//            }
//        });

    }
//
//    /**
//     * Clean up the media player by releasing its resources.
//     */
//    private void releaseMediaPlayer() {
//        // If the media player is not null, then it may be currently playing a sound.
//        if (mediaPlayer != null) {
//            // Regardless of the current state of the media player, release its resources
//            // because we no longer need it.
//            mediaPlayer.release();
//
//            // Set the media player back to null. For our code, we've decided that
//            // setting the media player to null is an easy way to tell that the media player
//            // is not configured to play an audio file at the moment.
//            mediaPlayer = null;
//
//
//            audioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
//        }
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        releaseMediaPlayer();
//    }
//
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId ()) {
//            // Respond to the action bar's Up/Home button
//            case android.R.id.home:
//                NavUtils.navigateUpFromSameTask(this);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
