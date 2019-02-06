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

public class ThirdActivity extends AppCompatActivity {
    User user;
    ArrayList<String> ArrayListfauxkanjis;
    TextView ScoreView;
    ListView listViewFauxkanjis;
    ArrayAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity);
        int score = getIntent().getIntExtra("score", 0);
        user = (User) getIntent().getSerializableExtra("user");
        user = new User();
        Serializable TestSize = getIntent().getSerializableExtra("test.size");
        Bundle bundle = getIntent().getExtras();
        ArrayListfauxkanjis = (ArrayList<String>) bundle.getStringArrayList("fauxkanjis");
        ScoreView = findViewById(R.id.JLPTView);
        listViewFauxkanjis = findViewById(R.id.Historic_ListView);
        ScoreView.setText("Correct answers" + ": " + " " + String.valueOf(score) + "/" + TestSize);
        if (user.getEmailAddress() == null) {
            Toast.makeText(getApplicationContext(), "Here are your results", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Here are your results" + " " + user.getEmailAddress(), Toast.LENGTH_LONG).show();
        }
        //todo insert users's results test into the distqnt database.
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



