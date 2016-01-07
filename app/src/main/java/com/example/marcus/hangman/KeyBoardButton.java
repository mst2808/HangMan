package com.example.marcus.hangman;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Marcus on 07.01.2016.
 */
public class KeyBoardButton extends View{

    public TypedArray a;
    private int xPos = -1;
    private int yPos = -1;
    private String text = "";



    private int buttonWidth, buttonHeight;

    public KeyBoardButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.KeyBoardButton,0,0);
    }

    private void init() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();

        if(xPos >= 0 && yPos >= 0) {
            canvas.drawText(text, xPos, yPos, paint);
            paint.setColor(Color.GREEN);
            canvas.drawRect(xPos, yPos, buttonWidth, buttonHeight, paint);
        }
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public void setButtonHeight(int buttonHeight) {
        this.buttonHeight = buttonHeight;
    }

    public void setButtonWidth(int buttonWidth) {
        this.buttonWidth = buttonWidth;
    }

    public void setText(String text) {
        this.text = text;
    }

}
