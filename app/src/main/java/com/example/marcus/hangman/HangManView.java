package com.example.marcus.hangman;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Marcus on 12.01.2016.
 */
public class HangManView extends TextView {

    private Paint paint = new Paint();
    private LayoutInflater mInflater;
    private Point p1 = new Point(50     ,400    );
    private Point p2 = new Point(150    ,p1.y   );
    private Point p3 = new Point(100    ,350    );
    private Point p4 = new Point(p3.x   , 50    );
    private Point p5 = new Point(400    ,p4.y   );
    private Point p6 = new Point(100    ,150    );
    private Point p7 = new Point(200    ,50     );
    private Point p8 = new Point(p5.x   ,p5.y + 50);
    private Point p9 = new Point(p8.x    ,p8.y + 50);
    private Point p10 = new Point(p8.x   ,p8.y + 150);
    private Point p11 = new Point(p8.x   ,p8.y + 70);
    private Point p12 = new Point(p8.x - 30 , p11.y + 30);
    private Point p13 = new Point(p8.x + 30 , p12.y    );
    private Point p14 = new Point(p10.x - 30, p10.y + 30);
    private Point p15 = new Point(p10.x + 30, p14.y );

    private Model model;

    public HangManView(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
//        init();
    }

    public HangManView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
//        init();
    }

    public HangManView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        mInflater = LayoutInflater.from(context);
//        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5f);
        paint.setStyle(Paint.Style.STROKE);

        int movesLeft = model.getMaxMoves() - model.getCurrentMovesLeft();

        if(movesLeft > 0) drawLine(p1, p3, canvas);
        if(movesLeft > 1) drawLine(p2, p3, canvas);
        if(movesLeft > 2) drawLine(p3, p4, canvas);
        if(movesLeft > 3) drawLine(p4, p5, canvas);
        if(movesLeft > 4) drawLine(p6, p7, canvas);
        if(movesLeft > 5) drawLine(p5, p8, canvas);
        if(movesLeft > 6) canvas.drawCircle(p8.x, p8.y + 25, 25, paint);
        if(movesLeft > 7) drawLine(p9, p10, canvas);
        if(movesLeft > 8) drawLine(p11, p12, canvas);
        if(movesLeft > 9) drawLine(p11, p13, canvas);
        if(movesLeft > 10) drawLine(p10, p14, canvas);
        if(movesLeft > 11) drawLine(p10, p15, canvas);
    }

    private void drawLine(Point p1, Point p2, Canvas c) {
        c.drawLine(p1.x, p1.y, p2.x, p2.y, paint);
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
