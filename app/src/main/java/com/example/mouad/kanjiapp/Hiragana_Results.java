package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Hiragana_Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana__results);
        int score = getIntent().getIntExtra("score", 0);
        Bundle bundle = getIntent().getExtras();
        ArrayList<String> dede = (ArrayList<String>) bundle.getStringArrayList("HiraganaFaux");
        TextView ScoreView = findViewById(R.id.JLPTView);
        TextView FauxList = findViewById(R.id.Historic_View);
        ListView ListView = findViewById(R.id.Historic_ListView);
        ScoreView.setText("Nombres de réponses juste " + " " + ": " + " " + String.valueOf(score));
        Toast.makeText(getApplicationContext(), "Voici vos resultats ! ", Toast.LENGTH_LONG).show();
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dede);
        ListView.setAdapter(adapter);
        //todo insert hiragana test into remote database.
    }

    public void buttonHome(View v) {
        Intent intent = new Intent(Hiragana_Results.this, MainActivity.class);
        Hiragana_Results.this.startActivity(intent);
    }

    public void buttonRetry(View v) {
        Intent intent = new Intent(Hiragana_Results.this, Hiragana_beforeT.class);
        Hiragana_Results.this.startActivity(intent);
    }
}
