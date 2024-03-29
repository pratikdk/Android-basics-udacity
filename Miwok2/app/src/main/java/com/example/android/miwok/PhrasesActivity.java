package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    //private ArrayList<Integer[]> subList = new ArrayList<Integer[]>();

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
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
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new PhrasesFragment()).commit();

//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.word_list);
//
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//
//        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
//
//        final ArrayList<Word> words = new ArrayList<Word>();
//        words.add(new Word("Where are you going?", "minto wuksus",
//                R.raw.phrase_where_are_you_going));
//        words.add(new Word("What is your name?", "tinnә oyaase'nә",
//                R.raw.phrase_what_is_your_name));
//        words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
//        words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
//        words.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
//        words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
//        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
//        words.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
//        words.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
//        words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));
//
//        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);
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
//                    mediaPlayer = MediaPlayer.create(PhrasesActivity.this, wordAudioID);
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
