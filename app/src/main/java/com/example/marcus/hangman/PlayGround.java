package com.example.marcus.hangman;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Marcus on 08.01.2016.
 */
public class PlayGround extends LinearLayout{

    private LayoutInflater mInflater;
    private TextView visibleWordTV;
    private TextView kategorieTV;
    private HangManView hangManView;

    public PlayGround(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
//        init();
    }

    public PlayGround(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
//        init();
    }

    public PlayGround(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        mInflater = LayoutInflater.from(context);
//        init();
    }


    public void init() {

//        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) this.getLayoutParams();
//        params.height = (int) (PlayActivity.dm.heightPixels * 0.8);
//        this.setLayoutParams(params);


        hangManView = (HangManView) findViewById(R.id.hangManView);
        hangManView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 20, 12f));
        hangManView.setBackgroundColor(Color.TRANSPARENT);

        kategorieTV = (TextView) findViewById(R.id.kategorie);
        kategorieTV.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 10, 2f));
        kategorieTV.setBackgroundColor(Color.TRANSPARENT);

        visibleWordTV = (TextView) findViewById(R.id.visiableWord);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 10, 3f);
//        params.gravity = Gravity.BOTTOM;
        visibleWordTV.setLayoutParams(params);
        visibleWordTV.setBackgroundColor(Color.TRANSPARENT);

        this.setBackgroundColor(Color.TRANSPARENT);
        this.postInvalidate();

    }

    public HangManView getHangManView() {
        return hangManView;
    }

    public TextView getKategorieTV() {
        return kategorieTV;
    }
}
