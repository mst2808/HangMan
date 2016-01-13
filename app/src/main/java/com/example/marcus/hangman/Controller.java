package com.example.marcus.hangman;

import android.util.Log;
import android.view.View;

/**
 * Created by Marcus on 11.01.2016.
 */
public class Controller implements View.OnClickListener {

    private Model model;
    private PlayActivity playActivity;

    public Controller(Model model, PlayActivity playActivity) {
        this.model = model; this.playActivity = playActivity;
    }


    @Override
    public void onClick(View v) {

        if(v.getClass() == KeyBoardButton.class) {
            model.buttonPressed(((KeyBoardButton) v).getText());
            playActivity.buttonPressed();
                    ((KeyBoardButton) v).setVisibility(View.INVISIBLE);

        }
    }
}
