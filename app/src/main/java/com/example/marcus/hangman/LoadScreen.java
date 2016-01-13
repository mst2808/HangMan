package com.example.marcus.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoadScreen extends AppCompatActivity {

    private Intent intent = new Intent();
    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);

        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playClickButton(view);
            }
        });

    }

    public void playClickButton(View view) {
        intent.setClass(this.getBaseContext(), PlayActivity.class);
        startActivity(intent);
    }
}
