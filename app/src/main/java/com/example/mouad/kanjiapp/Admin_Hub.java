package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Admin_Hub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__hub);
        Button button_Hiragana = findViewById(R.id.button_Hiragana);
        Button button_Katakana = findViewById(R.id.button_Katakana);
        Button button_Kanji = findViewById(R.id.button_Kanji);
    }


    public void button_Hiragana(View v) {
        Intent intent = new Intent(Admin_Hub.this, Admin_Hiragana.class);
        startActivity(intent);
    }

    public void button_Katakana(View v) {
        Button button_Katakana = findViewById(R.id.button_Katakana);
        Intent intent = new Intent(Admin_Hub.this, Admin_Katakana.class);
        startActivity(intent);
    }

    public void button_Kanji(View v) {
        Button button_Kanji = findViewById(R.id.button_Kanji);
        Intent intent = new Intent(Admin_Hub.this, Admin.class);
        startActivity(intent);
    }
}