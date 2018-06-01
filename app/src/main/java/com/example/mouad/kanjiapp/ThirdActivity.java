package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

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
            TextView ScoreView = findViewById(R.id.JLPTView);
            TextView FauxList  = findViewById(R.id.FauxList);
            ListView ListView  = findViewById(R.id.ListView);
            ScoreView.setText("Nombres de réponses juste " + " "+": "+" "+ String.valueOf(score));
            Toast.makeText(getApplicationContext(), "Voici vos resultats ! ", Toast.LENGTH_LONG).show();
            ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dede);
            ListView.setAdapter(adapter);
        }

        public void buttonHome (View v)
        {
            Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
            ThirdActivity.this.startActivity(intent);
        }

        public void buttonRetry (View v)
        {
            Intent intent = new Intent(ThirdActivity.this, Before_SecondScreen.class);
            ThirdActivity.this.startActivity(intent);
        }

}



