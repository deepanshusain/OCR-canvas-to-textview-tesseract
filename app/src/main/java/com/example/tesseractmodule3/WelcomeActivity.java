package com.example.tesseractmodule3;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.varunest.sparkbutton.SparkButton;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {

    MediaPlayer welcome,intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcome = MediaPlayer.create(this, R.raw.welcome);
        intro = MediaPlayer.create(this, R.raw.introduction);
        final SparkButton sparkButton = findViewById(R.id.sprkbtn);

        sparkButton.performClick();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

          welcome.start();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // this code will be executed after 5 seconds
                welcome.stop();
                welcome.reset();
                intro.start();
            }
        }, 5000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // this code will be executed after 17 seconds
                Intent startmain =  new Intent(WelcomeActivity.this,MainActivity.class);
                startmain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(startmain);
                intro.stop();
                intro.reset();
            }
        }, 17000);

    }
}
