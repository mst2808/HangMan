package com.example.marcus.hangman;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Marcus on 13.01.2016.
 */
public class Model{

    private PlayActivity playActivity;

    private Wort currentWord;
    private Character[] visiableWord;
    private WordList words = new WordList();

    private int maxMoves = 12;
    private int currentMovesLeft = maxMoves;
    private Toast popUpMessage;
    private int currentScore = 0;




    public Model(PlayActivity playActivity) {
        this.playActivity = playActivity;
    }

    public void buttonPressed(CharSequence text) {

        Boolean letterFound = false;

        for(int i = 0; i < currentWord.getValue().length(); i++) {
            if (currentWord.getValue().charAt(i) == text.toString().charAt(0) && visiableWord[i] == '_') {
                visiableWord[i] = text.charAt(0);
                letterFound = true;
                currentScore+= currentWord.getValue().length();
            }
        }

        if(!letterFound) {
            playActivity.wrongLetterChoosen();
            if(currentMovesLeft == 0) {

                popUpMessage = Toast.makeText(playActivity.getApplicationContext(), getCurrentWord().getValue() + " wäre das korrekte Wort gewesen!", Toast.LENGTH_LONG);
                popUpMessage.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 50);
                popUpMessage.show();

//                playActivity.resetPLayGround();
                playActivity.startSummery();

            }
        }

    }



    public void init() {

        popUpMessage = new Toast(playActivity);

        currentWord = words.getRandomWord();

        visiableWord = new Character[currentWord.getValue().length()];

        visiableWord[0] = currentWord.getValue().charAt(0);

        for(int i = 1; i < visiableWord.length; i++) {
            visiableWord[i] = '_';
        }

        currentMovesLeft = maxMoves;

    }

    public Character[] getVisiableWord() {
        return visiableWord;
    }

    public Wort getCurrentWord() {
        return currentWord;
    }

    public void decreaseMovesLeft() {
        currentMovesLeft--;
    }

    public int getMaxMoves() {
        return maxMoves;
    }

    public int getCurrentMovesLeft() {
        return currentMovesLeft;
    }

    public int getScore() {
        return currentScore;
    }

    public void increaseScoreByWin() {
        currentScore += currentWord.getValue().length() * currentWord.getValue().length();
    }

}
