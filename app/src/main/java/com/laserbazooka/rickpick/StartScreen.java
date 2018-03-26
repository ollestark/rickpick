package com.laserbazooka.rickpick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class StartScreen extends Activity {
    private ArrayList<String > diceArrey;
    private ArrayAdapter<String> diceAdapter;
    private ArrayList<String> flipArrey;
    private ArrayAdapter<String> flipAdapter;

    private Button btnDice;
    private Button btnFlip;
    private Button btnRandom;
    private Button btnSpin;

    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startscreen);
        setUpView();
    }


    private void setUpView() {
        // TODO Auto-generated method stub

        btnDice = (Button) this.findViewById(R.id.diceBtn);
        btnFlip = (Button) this.findViewById(R.id.flipBtn);
        btnRandom = (Button) this.findViewById(R.id.randBtn);
        btnSpin = (Button) this.findViewById(R.id.spinBtn);


        diceArrey = new ArrayList<String>();
        diceArrey.clear();

        flipArrey = new ArrayList<String>();
        flipArrey.clear();



        diceAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, diceArrey);
        flipAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, flipArrey);


        btnDice.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                diceArrey.add("1");
                diceArrey.add("2");
                diceArrey.add("3");
                diceArrey.add("4");
                diceArrey.add("5");
                diceArrey.add("6");

                diceAdapter.notifyDataSetChanged();


                diceScreen();


            }
        });

        btnFlip.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                flipArrey.add("krona");
                flipArrey.add("klave");

                flipAdapter.notifyDataSetChanged();


                flipScreen();


            }
        });

        btnRandom.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                randomScreen();


            }
        });

        btnSpin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                spinScreen();


            }
        });
    }


    public void diceScreen() {

        Intent intent = new Intent(this, DiceRoll.class);
        Random rand = new Random();
        String randomString = diceArrey.get(rand.nextInt(diceArrey.size()));
        intent.putExtra(EXTRA_MESSAGE, "Du fick " + randomString);
        startActivity(intent);


    }

    public void flipScreen() {

        Intent intent = new Intent(this, CoinFlip.class);
        Random rand = new Random();
        String randomString = flipArrey.get(rand.nextInt(flipArrey.size()));
        intent.putExtra(EXTRA_MESSAGE, "Myntet visar " + randomString);
        startActivity(intent);


    }

    public void randomScreen() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

    public void spinScreen() {

        Intent intent = new Intent(this, SpinActivity.class);
        startActivity(intent);


    }
}


