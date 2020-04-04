package com.example.tesseractmodule3;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;
public class Test2 extends AppCompatActivity {

    MediaPlayer test,right,wrong;
    Button A,B,C,D;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        test = MediaPlayer.create(this,R.raw.testtwo);
        right = MediaPlayer.create(this,R.raw.rightanswer);
        wrong = MediaPlayer.create(this,R.raw.wronganswer);

        A = findViewById(R.id.b);
        B = findViewById(R.id.a);
        C = findViewById(R.id.c);
        D = findViewById(R.id.d);

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                A.setBackgroundColor(Color.GREEN);

                test.stop();
                test.reset();
                right.start();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // this code will be executed after 5 seconds
                        right.stop();
                        right.reset();
                        Intent intent = new Intent(Test2.this, KAActivity.class);
                        finish();
                        startActivity(intent);
                    }
                }, 6000);

            }
        });

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                B.setBackgroundColor(Color.RED);

                test.stop();
                test.reset();
                wrong.start();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // this code will be executed after 5 seconds
                        wrong.stop();
                        wrong.reset();
                        Intent intent = new Intent(Test2.this, UUActivity.class);
                        finish();
                        startActivity(intent);
                    }
                }, 3000);

            }
        });

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                C.setBackgroundColor(Color.RED);

                test.stop();
                test.reset();
                wrong.start();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // this code will be executed after 5 seconds
                        wrong.stop();
                        wrong.reset();
                        Intent intent = new Intent(Test2.this, UUActivity.class);
                        finish();
                        startActivity(intent);
                    }
                }, 3000);

            }
        });

        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                D.setBackgroundColor(Color.RED);

                test.stop();
                test.reset();
                wrong.start();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // this code will be executed after 5 seconds
                        wrong.stop();
                        wrong.reset();
                        Intent intent = new Intent(Test2.this, UUActivity.class);
                        finish();
                        startActivity(intent);
                    }
                }, 3000);

            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // this code will be executed after 5 seconds
                test.start();
            }
        }, 2000);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // this code will be executed after 5 seconds
                test.stop();
                test.reset();
            }
        }, 5000);
    }


}
