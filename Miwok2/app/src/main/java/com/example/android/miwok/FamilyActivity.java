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

public class FamilyActivity extends AppCompatActivity {
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
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FamilyFragment()).commit();

//        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
//
//        final ArrayList<Word> words = new ArrayList<Word>();
//        words.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
//        words.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
//        words.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
//        words.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
//        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother,
//                R.raw.family_older_brother));
//        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother,
//                R.raw.family_younger_brother));
//        words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister,
//                R.raw.family_older_sister));
//        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister,
//                R.raw.family_younger_sister));
//        words.add(new Word("grandmother ", "ama", R.drawable.family_grandmother,
//                R.raw.family_grandmother));
//        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather,
//                R.raw.family_grandfather));
//
//        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);
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
//                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, wordAudioID);
//                    mediaPlayer.start();
//
//                    mediaPlayer.setOnCompletionListener(mCompletionListener);
//                }
//            }
//        });
    }
//
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
