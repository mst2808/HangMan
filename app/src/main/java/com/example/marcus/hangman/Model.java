package com.example.marcus.hangman;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Marcus on 13.01.2016.
 */
public class Model {

    private int maxMoves = 12;
    private int currentMovesLeft = maxMoves;

    private String currentWord;
    private Character[] visiableWord;
    private ArrayList<String> words = new ArrayList<String>();

    private PlayActivity playActivity;

    public Model(PlayActivity playActivity) {
        this.playActivity = playActivity;
    }

    public void buttonPressed(CharSequence text) {

        Boolean letterFound = false;

        for(int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) == text.toString().charAt(0) && visiableWord[i] == '_') {
                visiableWord[i] = text.charAt(0);
                letterFound = true;
            }
        }

        if(!letterFound) {
            playActivity.wrongLetterChoosen();
            if(currentMovesLeft == 0) {
                Toast.makeText(playActivity, "Sie haben verloren!", Toast.LENGTH_SHORT).show();
                playActivity.resetPLayGround();

            }
        }

    }



    public void init() {

        words.removeAll(words);

        words.add("DEUTSCHLAND");
        words.add("ENGLAND");
        words.add("FRANKREICH");
        words.add("SPANIEN");
        words.add("ITALIEN");
        words.add("SCHWEIZ");

        currentWord = words.get((int) (Math.random() * words.size()));
        visiableWord = new Character[currentWord.length()];

        visiableWord[0] = currentWord.charAt(0);

        for(int i = 1; i < visiableWord.length; i++) {
            visiableWord[i] = '_';
        }

        currentMovesLeft = maxMoves;

    }

    public Character[] getVisiableWord() {
        return visiableWord;
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
}
