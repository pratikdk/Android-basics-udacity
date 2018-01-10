package com.example.android.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView firstTextView = (TextView) findViewById(R.id.menu_item_1);
        Log.i("menu_item_1", (String) firstTextView.getText());

        // Find second menu item TextView and print the text to the logs
        TextView secondTextView = (TextView) findViewById(R.id.menu_item_2);
        Log.i("menu_item_2", (String) secondTextView.getText());

        // Find third menu item TextView and print the text to the logs
        TextView thirdTextView = (TextView) findViewById(R.id.menu_item_3);
        Log.i("menu_item_3", (String) thirdTextView.getText());
    }
}
