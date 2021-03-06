package com.example.marcus.hangman;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class PlayActivity extends Activity {

    private Toast popUpMessage;

    private PlayGround playGround;
    private KeyBoard keyBoard;

    public DisplayMetrics dm;
    public LinearLayout mainLayout;
    private TextView visibleWordTV;
    private TextView score;

    private Model model;
    private Controller controller;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dm = getResources().getDisplayMetrics();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_play);

        model = new Model(this);
        controller = new Controller(model, this);
        popUpMessage = new Toast(this);

        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        playGround = (PlayGround) findViewById(R.id.playGround);
        keyBoard = (KeyBoard) findViewById(R.id.keyBoard);
        visibleWordTV = (TextView) findViewById(R.id.visiableWord);
        score = (TextView) findViewById(R.id.scoreView);

        init();

        score.setText("Aktuelle Punktzahl\t" + model.getScore());
    }

    public void resetPLayGround() {
        init();
    }

    private void init() {

        model.init();

        visibleWordTV.setText(transmuteCharArray(model.getVisiableWord()));

        playGround.init();
        playGround.getHangManView().setModel(model);
        keyBoard.setController(controller);
        keyBoard.init();

        playGround.getKategorieTV().setText(model.getCurrentWord().getCategory());

        mainLayout.invalidate();

    }

    public void buttonPressed() {

        visibleWordTV.setText(transmuteCharArray(model.getVisiableWord()));

        if(checkWon()) {

            popUpMessage = Toast.makeText(getApplicationContext(), "Richtig, das Wort war " + model.getCurrentWord().getValue(), Toast.LENGTH_LONG);
            popUpMessage.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 50);
            popUpMessage.show();

            model.increaseScoreByWin();

            resetPLayGround();
        }

        score.setText("Aktuelle Punktzahl\t" + model.getScore());
        mainLayout.postInvalidate();

    }

    private boolean checkWon() {

        Character[] temp = model.getVisiableWord();

        for(int i = 1; i < temp.length; i++) {
            if(temp[i] == '_') return false;
        }

        return true;
    }

    public String transmuteCharArray(Character[] visiableWord) {

        String back = "";

        for(int i = 0; i < visiableWord.length; i++) {
            back += visiableWord[i] + " ";
        }

        return back;
    }

    public void wrongLetterChoosen() {
        model.decreaseMovesLeft();
        playGround.getHangManView().invalidate();
    }

    public void startSummery() {
        intent = getIntent();
        intent.setClass(this, SummeryActivity.class);
        intent.putExtra("score", model.getScore());
        intent.putExtra("date", System.currentTimeMillis());
        startActivity(intent);
    }
}
