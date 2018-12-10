package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Kanji_HUB extends AppCompatActivity {
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanji__hub);
        TextView text = findViewById(R.id.textView18);
        Button button_TEST = findViewById(R.id.button_TEST);
        Button button_LECON = findViewById(R.id.button_LECON);
        user = (User)getIntent().getSerializableExtra("user");
    }

    public void button_TEST (View v){
        Button button_TEST = findViewById(R.id.Admin_Button);
        Intent intent = new Intent(Kanji_HUB.this, Before_SecondScreen.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }

    public void button_LECON (View v){
        Button button_LECON = findViewById(R.id.Admin_Button);
        Intent intent = new Intent(Kanji_HUB.this, Learn_Kanji.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }
}
