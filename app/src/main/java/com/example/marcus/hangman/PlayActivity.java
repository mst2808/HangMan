package com.example.marcus.hangman;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
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

    private PlayGround playGround;
    private KeyBoard keyBoard;

    public DisplayMetrics dm;
    public LinearLayout mainLayout;
    private TextView visibleWordTV;

    private Model model = new Model(this);
    private Controller controller = new Controller(model, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dm = getResources().getDisplayMetrics();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_play);

        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        playGround = (PlayGround) findViewById(R.id.playGround);
        keyBoard = (KeyBoard) findViewById(R.id.keyBoard);
        visibleWordTV = (TextView) findViewById(R.id.visiableWord);

        init();
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


        mainLayout.invalidate();

    }

    public void buttonPressed() {

        visibleWordTV.setText(transmuteCharArray(model.getVisiableWord()));
        mainLayout.postInvalidate();

        if(checkWon()) {
            resetPLayGround();
        }

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

}
