package com.laserbazooka.rickpick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;


public class SpinActivity extends Activity {
    private ArrayList<String> penList;
    private ArrayAdapter<String> penAdapter;
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin);
        setUpView();
    }

    public void setUpView() {

        penList = new ArrayList<String>();
        penList.clear();

        penAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, penList);

        penList.add("Skicka 'du och jag borde starta ett band' till senaste sms-kontakten");
        penList.add("Tala i rim tills det blir du igen");
        penList.add("Visa din ultimata breakdance-move");
        penList.add("Beskriv med ord hur du onanerar");
        penList.add("Vilket djur hade du helst velat ha sex med?");
        penList.add("Har du slickat anus?");
        penList.add("Ring upp din tjugonde telefonbokskontakt och prata polska i 30 sekunder");
        penList.add("Di fir biri priti i-sprikit (Byt ut alla vokaler mot 'i')");
        penList.add("Beskriv ditt perfekta mord, inklusive offer");
        penList.add("Rocka en Kris Kross-outfit");
        penList.add("Du blev precis en slav, utse din egen master");
        penList.add("Spela upp din favorit-musikvideo, in character");
        penList.add("Inled alla meningar med 'Som my homeboy Snoop sa...'");
        penList.add("Vilken fiktiv person identifierar du dig med?");
        penList.add("Du har nu Downs syndrom");
        penList.add("Sjung 'Happy Birthday Dear Frej' (minst en freestylad vers)");
        penList.add("Sjung 'Happy Birthday Dear Frej' (minst en freestylad vers)");
        penList.add("Sjung 'Happy Birthday Dear Frej' (minst en freestylad vers)");
        penList.add("Sjung 'Happy Birthday Dear Frej' (minst en freestylad vers)");
        penList.add("Sjung 'Happy Birthday Dear Frej' (minst en freestylad vers)");
        penList.add("Sjung 'Happy Birthday Dear Frej' (minst en freestylad vers)");
        penList.add("Sjung 'Happy Birthday Dear Frej' (minst en freestylad vers)");
        penList.add("Sjung 'Happy Birthday Dear Frej' (minst en freestylad vers)");
        penList.add("Sjung 'Happy Birthday Dear Frej' (minst en freestylad vers)");
        penList.add("Sjung 'Happy Birthday Dear Frej' (minst en freestylad vers)");

        penAdapter.notifyDataSetChanged();
    }

    public void spinning(View view) {

/**
 ImageView image = (ImageView)findViewById(R.id.bottle);
 Animation spinAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.spin);
 image.startAnimation(spinAnimation);
 */

        RotateAnimation rotate = new RotateAnimation(0, generateRandomNumber(), Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(5000);
        rotate.setFillAfter(true);
        rotate.setInterpolator(new LinearInterpolator());

        ImageView image = (ImageView) findViewById(R.id.bottle);

        image.startAnimation(rotate);

        rotate.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation rotate) {

                penScreen();
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




    public void penScreen() {
        Intent intent = new Intent(this, DisplayPen.class);
        Random rand = new Random();
        String randString = penList.get(rand.nextInt(penList.size()));
        intent.putExtra(EXTRA_MESSAGE, randString);
        startActivity(intent);

    }

}





