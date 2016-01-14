package com.example.marcus.hangman;

import java.util.Date;

/**
 * Created by Marcus on 14.01.2016.
 */
public class Score {

    private int score;
    private long date;

    public Score(int score, long millis) {
        this.score = score;
        this.date = millis;
    }

    public int getScore() {
        return score;
    }

    public long getDate() {
        return date;
    }
}
