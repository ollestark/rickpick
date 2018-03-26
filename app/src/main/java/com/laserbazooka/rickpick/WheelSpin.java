package com.laserbazooka.rickpick;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class WheelSpin extends Activity {
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel);
        spinning();
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.spinwheel);
        mp.start();

    }

    public void spinning() {
        RotateAnimation rotate = new RotateAnimation(0, generateRandomNumber(), Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(5000);
        rotate.setFillAfter(true);
        rotate.setInterpolator(new LinearInterpolator());

        ImageView image = (ImageView) findViewById(R.id.spinWheel);

        image.startAnimation(rotate);

        rotate.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation rotate) {

                pickScreen();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    public float generateRandomNumber() {

        Random rand = new Random();
        int randomNum = rand.nextInt((2160 - 0) + 1);

        return (float) randomNum;
    }




    public void pickScreen() {
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.picked);
        textView.setText(message);
        Intent intent2 = new Intent(this, DisplayMessageActivity.class);
        intent2.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent2);

    }
}

