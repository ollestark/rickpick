package com.laserbazooka.rickpick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class DisplayMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra(WheelSpin.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.picked);
        textView.setTextSize(30);
        textView.setText(message);

    }




}
