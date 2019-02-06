package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mouad on 27/12/2017.
 */

public class ThirdActivity extends AppCompatActivity {
    User user;
    ArrayList<String> ArrayListfauxkanjis;
    TextView ScoreView;
    ListView listViewFauxkanjis;
    ArrayAdapter adapter;
    private static DistantAccess distantAccess;
    String niveauJLPT;
    int score;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity);
        score = getIntent().getIntExtra("score", 0);
        niveauJLPT = getIntent().getExtras().getString("niveauJLPT");
        user = new User();
        user = (User) getIntent().getSerializableExtra("user");
        distantAccess = new DistantAccess();
        Serializable TestSize = getIntent().getSerializableExtra("test.size");
        Bundle bundle = getIntent().getExtras();
        ScoreView = findViewById(R.id.JLPTView);
        ArrayListfauxkanjis = (ArrayList<String>) bundle.getStringArrayList("fauxkanjis");
        Test_history test_history = new Test_history("\"" + niveauJLPT+ "\"",score,"\"" +user.getEmailAddress()+ "\"");
        listViewFauxkanjis = findViewById(R.id.Historic_ListView);
        ScoreView.setText("Correct answers" + ": " + " " + String.valueOf(score) + "/" + TestSize);
        distantAccess.envoi("insert_test_history",test_history.convertToJSONArray());
        if (user.getEmailAddress() == null) {
            Toast.makeText(getApplicationContext(), "Here are your results", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Here are your results" + " " + user.getEmailAddress(), Toast.LENGTH_LONG).show();
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ArrayListfauxkanjis);
        listViewFauxkanjis.setAdapter(adapter);
    }

    public void buttonHome(View v) {
        Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
        intent.putExtra("user", user);
        ThirdActivity.this.startActivity(intent);
    }

    public void buttonRetry(View v) {
        Intent intent = new Intent(ThirdActivity.this, Before_SecondScreen.class);
        intent.putExtra("user", user);
        ThirdActivity.this.startActivity(intent);
    }
}



