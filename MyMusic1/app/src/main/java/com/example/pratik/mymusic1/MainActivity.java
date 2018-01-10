package com.example.pratik.mymusic1;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private Button buttonRewind, buttonPause, buttonPlay, buttonForward;
    private ImageView albumArt;
    private MediaPlayer mediaPlayer;

    private double currentTime = 0;
    private double finalTime = 0;

    private Handler myHandler = new Handler();
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekBar;
    private TextView songCurrentTime, songEndTime, songInfo;

    private static int oneTimeOnly = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonRewind = (Button) findViewById(R.id.button_rewind);
        buttonPause = (Button) findViewById(R.id.button_pause);
        buttonPlay = (Button) findViewById(R.id.button_back);
        buttonForward = (Button) findViewById(R.id.button_forward);

        albumArt = (ImageView) findViewById(R.id.album_art);

        songCurrentTime = (TextView) findViewById(R.id.current_time);
        songEndTime = (TextView) findViewById(R.id.end_time);
        songInfo = (TextView) findViewById(R.id.song_name);
        songInfo.setText("Alan Walker - The Spectre");

        mediaPlayer = MediaPlayer.create(this, R.raw.song);

        seekBar = (SeekBar) findViewById(R.id.timeline_bar);
        seekBar.setClickable(false);

        buttonPause.setEnabled(false);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();

                finalTime = mediaPlayer.getDuration();
                currentTime = mediaPlayer.getCurrentPosition();

                if (oneTimeOnly == 0) {
                    seekBar.setMax((int) finalTime);
                    oneTimeOnly = 1;
                }

                songEndTime.setText(String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime))));

                songCurrentTime.setText(String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes((long) currentTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) currentTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) currentTime))));

                seekBar.setProgress((int) currentTime);
                myHandler.postDelayed(UpdateSongTime,100);

                buttonPause.setEnabled(true);
                buttonPlay.setEnabled(false);
            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
                buttonPause.setEnabled(false);
                buttonPlay.setEnabled(true);
            }
        });

        buttonForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = (int) currentTime;
                if ((temp + forwardTime) <= finalTime) {
                    currentTime += forwardTime;
                    mediaPlayer.seekTo((int) currentTime);
                } else{
                    Toast.makeText(getApplicationContext(),"Cannot jump forward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonRewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = (int) currentTime;
                if ((temp - backwardTime) > 0) {
                    currentTime -= backwardTime;
                    mediaPlayer.seekTo((int) currentTime);
                } else{
                    Toast.makeText(getApplicationContext(),"Cannot jump backward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            currentTime = mediaPlayer.getCurrentPosition();
            songCurrentTime.setText(String.format("%d:%d",
                    TimeUnit.MILLISECONDS.toMinutes((long) currentTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) currentTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) currentTime))));
            seekBar.setProgress((int) currentTime);
            myHandler.postDelayed(this, 100);
        }
    };

}
