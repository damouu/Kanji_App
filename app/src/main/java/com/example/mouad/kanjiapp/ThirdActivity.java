package com.example.mouad.kanjiapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mouad on 27/12/2017.
 */

public class ThirdActivity extends AppCompatActivity
{
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.thirdactivity);
            int score = getIntent().getIntExtra("score",0);
            Bundle bundle = getIntent().getExtras();
            ArrayList<String> dede = (ArrayList<String>) bundle.getStringArrayList("fauxkanjis");
            TextView ScoreView = findViewById(R.id.ScoreView);
            TextView FauxList  = findViewById(R.id.FauxList);
            ListView ListView  = findViewById(R.id.ListView);
            ScoreView.setText("Your score" + " "+ String.valueOf(score));
            Toast.makeText(getApplicationContext(), "Here's your results ! ", Toast.LENGTH_LONG).show();
            ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dede);
            ListView.setAdapter(adapter);
        }

        public void buttonOnClickX (View v)
        {

        }

        public void buttonTest (View v)
        {

        }

}



