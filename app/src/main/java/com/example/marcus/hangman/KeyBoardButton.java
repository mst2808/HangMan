package com.example.marcus.hangman;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Marcus on 07.01.2016.
 */
public class KeyBoardButton extends Button{

    public TypedArray a;
    private int xPos = -1;
    private int yPos = -1;
    private String text = "";



    private int buttonWidth, buttonHeight;

    public KeyBoardButton(Context context, AttributeSet attrs, int bla) {
        super(context, attrs, bla);
        a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.KeyBoardButton,0,0);
    }


    @Override
    public String toString() {
        return "X:" + xPos + "\tY:" + yPos + "\tbw:" + buttonWidth + "\tbh:" + buttonHeight;
    }

}
