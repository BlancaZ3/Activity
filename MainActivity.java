package com.example.activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.activity.R;

public class MainActivity extends AppCompatActivity {

    private int teamAScore = 0;
    private int teamBScore = 0;
    private TextView teamAScoreTextView;
    private TextView teamBScoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamAScoreTextView = findViewById(R.id.teamA_score_textview);
        teamBScoreTextView = findViewById(R.id.teamB_score_textview);

        Button teamAAdd1Button = findViewById(R.id.teamA_add1_button);
        Button teamAAdd3Button = findViewById(R.id.teamA_add3_button);
        Button teamAAdd5Button = findViewById(R.id.teamA_add5_button);

        Button teamBAdd1Button = findViewById(R.id.teamB_add1_button);
        Button teamBAdd3Button = findViewById(R.id.teamB_add3_button);
        Button teamBAdd5Button = findViewById(R.id.teamB_add5_button);

        Button resetButton = findViewById(R.id.reset_button);

        teamAAdd1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore += 1;
                teamAScoreTextView.setText("Team A Score: " + teamAScore);
            }
        });

        teamAAdd3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore += 3;
                teamAScoreTextView.setText("Team A Score: " + teamAScore);
            }
        });

        teamAAdd5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore += 5;
                teamAScoreTextView.setText("Team A Score: " + teamAScore);
            }
        });

        teamBAdd1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore += 1;
                teamBScoreTextView.setText("Team B Score: " + teamBScore);
            }
        });

        teamBAdd3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore += 3;
                teamBScoreTextView.setText("Team B Score: " + teamBScore);
            }
        });

        teamBAdd5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore += 5;
                teamBScoreTextView.setText("Team B Score: " + teamBScore);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore = 0;
                teamBScore = 0;
                teamAScoreTextView.setText("Team A Score: 0");
                teamBScoreTextView.setText("Team B Score: 0");
            }
        });
    }
}