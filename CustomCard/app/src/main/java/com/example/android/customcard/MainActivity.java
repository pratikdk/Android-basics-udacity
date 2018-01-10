package com.example.android.customcard;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        ImageView imageView1 = (ImageView) findViewById(R.id.sub_layout1);
        AnimationDrawable animationDrawable2 = (AnimationDrawable) imageView1.getBackground();
        animationDrawable2.setEnterFadeDuration(2000);
        animationDrawable2.setExitFadeDuration(4000);
        animationDrawable2.start();

        ImageView imageView2 = (ImageView) findViewById(R.id.sub_layout2);
        AnimationDrawable animationDrawable3 = (AnimationDrawable) imageView2.getBackground();
        animationDrawable3.setEnterFadeDuration(2000);
        animationDrawable3.setExitFadeDuration(4000);
        animationDrawable3.start();
    }
}
