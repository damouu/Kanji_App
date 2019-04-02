package com.example.mouad.kanjiapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Kanji_HUB extends AppCompatActivity {
    User user;
    Button button_TEST;
    Button button_LECON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanji__hub);
        TextView text = findViewById(R.id.textView18);
        button_TEST = findViewById(R.id.button_TEST);
        button_LECON = findViewById(R.id.button_LECON);
        user = new User();
        user = (User) getIntent().getSerializableExtra("user");
    }

    public void button_TEST(View v) {
        if (user == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Kanji_HUB.this);
            builder.setCancelable(true);
            builder.setTitle("Warning");
            builder.setMessage("You must be logged to pass a test");
            builder.setPositiveButton("Log in ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Kanji_HUB.this, LoginUserActivity.class);
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("Sign in", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Kanji_HUB.this, SignInUserActivity.class);
                    startActivity(intent);
                }
            });
            builder.show();
        } else {
            Intent intent = new Intent(Kanji_HUB.this, Before_SecondScreen.class);
            intent.putExtra("user", user);
            startActivity(intent);
        }
    }

    public void button_LECON(View v) {
        Intent intent = new Intent(Kanji_HUB.this, Learn_Kanji.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }
}
