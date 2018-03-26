package com.laserbazooka.rickpick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;



/** Note that here we are inheriting ListActivity class instead of Activity class **/
public class MainActivity extends Activity {
    private EditText etInput;
    private Button btnAdd;
    private ListView lvItem;
    private Button btnPick;
    private ArrayList<String> itemArrey;
    private ArrayAdapter<String> itemAdapter;


    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();

        /**   NYTT  */
        lvItem .setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                itemArrey.remove(position);
                itemAdapter.notifyDataSetChanged();
            }

        });
                /** NYTT    */

    }

    private void setUpView() {
        // TODO Auto-generated method stub
        etInput = (EditText)this.findViewById(R.id.edit_message);
        btnAdd = (Button)this.findViewById(R.id.addBtn);
        btnPick = (Button)this.findViewById(R.id.pickBtn);
        lvItem = (ListView)this.findViewById(R.id.listView_items);


        itemArrey = new ArrayList<String>();
        itemArrey.clear();

        itemAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,itemArrey);
        lvItem.setAdapter(itemAdapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                addItemList();
            }
        });

        btnPick.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                pickScreen();


            }
        });


    }


    protected void addItemList() {

        if (isInputValid(etInput)) {
            itemArrey.add(etInput.getText().toString());
            etInput.setText("");

            itemAdapter.notifyDataSetChanged();

        }

    }

    public void pickScreen() {

        if (itemArrey.isEmpty()) {
            Toast.makeText(this, "Vad vill du välja emellan?", Toast.LENGTH_LONG).show();

        } else {
            Intent intent = new Intent(this, WheelSpin.class);
            Random rand = new Random();
            String randomString = itemArrey.get(rand.nextInt(itemArrey.size()));
            intent.putExtra(EXTRA_MESSAGE, "RickPick väljer " + randomString + "!");
            startActivity(intent);

        }
    }


    protected boolean isInputValid(EditText etInput2) {
        // TODO Auto-generatd method stub
        if (etInput2.getText().toString().trim().length()<1) {
            etInput2.setError("Alternativ saknas");
            return false;
        } else {
            return true;
        }

    }


}