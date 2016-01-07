package com.example.marcus.hangman;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class PlayActivity extends Activity {

    private KeyBoard kb;
    private DisplayMetrics dm;
    private FrameLayout fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play);

        kb = (KeyBoard) findViewById(R.id.KeyBoard);

        kb.setHeight(20);
        kb.setWidth(getResources().getDisplayMetrics().widthPixels);

    }


}
