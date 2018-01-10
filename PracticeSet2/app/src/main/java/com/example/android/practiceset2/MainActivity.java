package com.example.android.practiceset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int weekday = 5;
        int weekend = 9;
        int optimalHours = 7 * 8;
        //int actualHours = weekday;
        int actualHours = weekday * 5 + weekend * 2;
        int solution = optimalHours - actualHours;
        display(solution);
        //display1("This is Box 1.");
        //display2("And this is Box 2.");
        //display3("And look! Box 3!");
    }

    public void display(String text) {
        TextView t = (TextView) findViewById(R.id.dispaly_text_view);
        t.setText(text + "");
    }

    public void display(int text) {
        TextView t = (TextView) findViewById(R.id.dispaly_text_view);
        t.setText(text + "");
    }

    public void display1(String text) {
        display(text);
    }

    public void display2(String text) {
        TextView t = (TextView) findViewById(R.id.dispaly_text_view2);
        t.setText(text);
    }

    public void display3(String text) {
        TextView t = (TextView) findViewById(R.id.dispaly_text_view3);
        t.setText(text);
    }
}
