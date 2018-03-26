package com.laserbazooka.rickpick;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class CoinFlip extends Activity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_flip);
         Intent intent = getIntent();
         String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
         TextView textView = (TextView) findViewById(R.id.fliped);
         textView.setTextSize(30);
         textView.setText(message);
         MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.coinflip);
         mp.start();

    }

}
