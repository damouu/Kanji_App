package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Hiragana_HUB extends AppCompatActivity {
    TextView text;
    Button button_TEST;
    Button button_LECON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana__hub);
        text = findViewById(R.id.textView18);
        button_TEST = findViewById(R.id.button_TEST);
        button_LECON = findViewById(R.id.button_LECON);
    }

    public void button_TEST(View v) {
        Intent intent = new Intent(Hiragana_HUB.this, Hiragana_beforeT.class);
        startActivity(intent);
    }

    public void button_LECON(View v) {
        Intent intent = new Intent(Hiragana_HUB.this, Hiragana_Learn.class);
        startActivity(intent);
    }
}

