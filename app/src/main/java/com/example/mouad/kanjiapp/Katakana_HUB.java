package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Katakana_HUB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katakana__hub);
        Button button_TEST = findViewById(R.id.button_TEST);
        Button button_LECON = findViewById(R.id.button_LECON);
    }

    public void button_TEST (View v){
        Button button_TEST = findViewById(R.id.Admin_Button);
        Intent intent = new Intent(Katakana_HUB.this, Katakana_beforeT.class);
        startActivity(intent);
    }

    public void button_LECON (View v){
        Button button_LECON = findViewById(R.id.Admin_Button);
        Intent intent = new Intent(Katakana_HUB.this, Katakana_Learn.class);
        startActivity(intent);
    }
}
