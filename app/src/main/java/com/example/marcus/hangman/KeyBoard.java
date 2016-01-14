package com.example.marcus.hangman;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.GridLayout;

/**
 * Created by Marcus on 07.01.2016.
 */
public class KeyBoard extends GridLayout{

    public static int HEIGHT, WIDTH;

    private Button[] buttons = new Button[26];
    private String[] letters = {
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };
    private Controller controller;

    private LayoutInflater mInflater;

    public KeyBoard(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
//        init();
    }

    public KeyBoard(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
//        init();
    }

    public KeyBoard(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        mInflater = LayoutInflater.from(context);
//        init();
    }

    public void init() {

        this.setBackgroundColor(Color.TRANSPARENT);
        this.removeAllViews();

        this.setRowCount(4);
        this.setColumnCount(7);

        for(int i = 0; i < buttons.length; i++) {
            buttons[i] = new KeyBoardButton(getContext(), null, R.attr.buttonStyleSmall);
            buttons[i].setText(letters[i]);
            buttons[i].setOnClickListener(controller);
            buttons[i].setEnabled(true);
            buttons[i].invalidate();

            this.addView(buttons[i]);
        }


        this.postInvalidate();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
