package com.example.mouad.kanjiapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Katakana_HUB extends AppCompatActivity {
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katakana__hub);
        Button button_TEST = findViewById(R.id.button_TEST);
        Button button_LECON = findViewById(R.id.button_LECON);
        user = new User();
        user = (User) getIntent().getSerializableExtra("user");
    }

    public void button_TEST(View v) {
        if (user == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Katakana_HUB.this);
            builder.setCancelable(true);
            builder.setTitle("Warning");
            builder.setMessage("You must be logged to pass a test");
            builder.setPositiveButton("Log in ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Katakana_HUB.this, LoginUserActivity.class);
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("Sign in", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Katakana_HUB.this, SignInUserActivity.class);
                    startActivity(intent);
                }
            });
            builder.show();
        } else {
            Intent intent = new Intent(Katakana_HUB.this, Katakana_beforeT.class);
            intent.putExtra("user", user);
            startActivity(intent);
        }
    }

    public void button_LECON(View v) {
        Button button_LECON = findViewById(R.id.Admin_Button);
        Intent intent = new Intent(Katakana_HUB.this, Katakana_Learn.class);
        startActivity(intent);
    }
}
