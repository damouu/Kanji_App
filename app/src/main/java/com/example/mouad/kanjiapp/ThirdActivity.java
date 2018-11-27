package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mouad on 27/12/2017.
 */

public class ThirdActivity extends AppCompatActivity
{
    User user;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity);
        int score = getIntent().getIntExtra("score",0);
        user = (User)getIntent().getSerializableExtra("user");
        Serializable TestSize = getIntent().getSerializableExtra("test.size");
        Bundle bundle = getIntent().getExtras();
        ArrayList<String> dede = (ArrayList<String>) bundle.getStringArrayList("fauxkanjis");
        TextView ScoreView = findViewById(R.id.JLPTView);
        TextView FauxList  = findViewById(R.id.Historic_View);
        ListView ListView  = findViewById(R.id.Historic_ListView);
        ScoreView.setText("Correct answers"+": "+" "+ String.valueOf(score)+"/"+ TestSize);
        Toast.makeText(getApplicationContext(), "Here are your results"  + " " + user.GetPseudo(), Toast.LENGTH_LONG).show();
        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dede);
        ListView.setAdapter(adapter);
        }

        public void buttonHome (View v) {
            Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
            intent.putExtra("user",user);
            ThirdActivity.this.startActivity(intent);
        }

        public void buttonRetry (View v) {
            Intent intent = new Intent(ThirdActivity.this, Before_SecondScreen.class);
            intent.putExtra("user",user);
            ThirdActivity.this.startActivity(intent);
        }

}



