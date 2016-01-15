package com.example.marcus.hangman;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SummeryActivity extends AppCompatActivity {

    private ArrayList<Score> highScores = new ArrayList<Score>();
    private SharedPreferences sharedPreferences;
    private Intent intent;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    public static final String MyPREFERENCES = "MyPrefs" ;

    private TextView informationTV;
    private TextView oldScoreTV;
    private TextView oldDateTV;
    private TextView newScoreTV;
    private TextView newDateTV;

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_summery);

        intent = getIntent();

        informationTV = (TextView) findViewById(R.id.informationTV);
        oldScoreTV = (TextView) findViewById(R.id.oldScoreTV);
        oldDateTV = (TextView) findViewById(R.id.oldDateTV);
        newScoreTV = (TextView) findViewById(R.id.newScoreTV);
        newDateTV = (TextView) findViewById(R.id.newDateTV);

        pref = getSharedPreferences("GAME", 0);

        informationTV.setText("Leider kein neuer Highscore!");

        if(pref.getInt("HIGHSCORE", 0) < intent.getIntExtra("score",0)) {
            informationTV.setText("Sie haben einen neuen Highscore aufgestellt!");
            addHighScoreToFile(new Score(intent.getIntExtra("score", 0), intent.getLongExtra("date", 0)));

        }

        showNewScore();

    }

    private void showNewScore() {
        oldScoreTV.setText("" + pref.getInt("HIGHSCORE", 0));
        oldDateTV.setText("" + sdf.format(new Date(pref.getLong("HIGHSCOREDATE", 0))));
        newScoreTV.setText("" + intent.getIntExtra("score", 0));
        newDateTV.setText("" + sdf.format(new Date(intent.getLongExtra("date", 0))));

        Log.d("MYLOG ", "" + pref.getInt("HIGHSCORE", 0));
        Log.d("MYLOG ", "" + pref.getLong("HIGHSCOREDATE", 0));

    }

    public void addHighScoreToFile(Score score) {

        SharedPreferences pref = getSharedPreferences("GAME", 0);
        SharedPreferences.Editor editor = pref.edit();
//        editor.putInt("HIGHSCORE", score.getScore());
        editor.putInt("HIGHSCORE", 0);
        editor.putLong("HIGHSCOREDATE", score.getDate());
        editor.commit();

    }
}
