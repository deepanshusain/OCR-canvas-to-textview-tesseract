package com.example.tesseractmodule3;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class LASTActivity extends AppCompatActivity {

    MediaPlayer last;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        last = MediaPlayer.create(this,R.raw.end);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        last.start();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // this code will be executed after 5 seconds
                last.stop();
                finish();
                System.exit(0);
            }
        }, 5000);

    }
}
