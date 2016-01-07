package com.example.marcus.hangman;

import android.app.ActionBar;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Marcus on 07.01.2016.
 */
public class KeyBoard extends RelativeLayout{

    private KeyBoardButton button;
    private int height, width;
    private LayoutInflater mInflater;;

    public KeyBoard(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
        init();
    }

    public KeyBoard(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
        init();
    }

    public KeyBoard(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        mInflater = LayoutInflater.from(context);
        init();
    }



    private void init() {
        this.setLayoutParams(new ActionBar.LayoutParams(width, height));
        button = new KeyBoardButton(getContext(), null);
        button.setXPos(50);
        button.setYPos(50);
        button.setButtonHeight(20);
        button.setButtonWidth(Math.round(width / 13));
        button.setText("A");
        button.invalidate();

        this.addView(button);
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }


}
