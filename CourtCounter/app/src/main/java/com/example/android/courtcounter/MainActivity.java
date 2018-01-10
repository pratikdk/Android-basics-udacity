package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int teamAScore = 0;
    private int teamBScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //displayForTeamA(8);
    }

    public void incrementByThreeA(View v) {
        teamAScore = teamAScore + 3;
        displayForTeamA(teamAScore);
    }

    public void incrementByTwoA(View v) {
        teamAScore = teamAScore + 2;
        displayForTeamA(teamAScore);
    }

    public void incrementByOneA(View v) {
        teamAScore = teamAScore + 1;
        displayForTeamA(teamAScore);
    }

    public void incrementByThreeB(View v) {
        teamBScore = teamBScore + 3;
        displayForTeamB(teamBScore);
    }

    public void incrementByTwoB(View v) {
        teamBScore = teamBScore + 2;
        displayForTeamB(teamBScore);
    }

    public void incrementByOneB(View v) {
        teamBScore = teamBScore + 1;
        displayForTeamB(teamBScore);
    }

    public void resetScore(View v) {
        teamAScore = 0;
        teamBScore = 0;
        displayForTeamA(teamAScore);
        displayForTeamB(teamBScore);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
