package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class LoginPage extends AppCompatActivity implements Serializable {
    DataBaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button LogInButton = findViewById(R.id.LogInButton);
        TextView LogInMail = findViewById(R.id.LogInMail);
        TextView LogInPassword = findViewById(R.id.LogInPassword);
        myDb = new DataBaseHelper(this);
        LogInMail.getText();
        LogInPassword.getText();
    }

    public void LogInButton(View v) {
        TextView LogInMail = findViewById(R.id.LogInMail);
        TextView LogInPassword = findViewById(R.id.LogInPassword);
        LogInMail.getText();
        LogInPassword.getText();
        if (LogInMail.getText().toString().trim().length() == 0 || LogInPassword.getText().toString().trim().length() == 0) {
            Toast.makeText(LoginPage.this, "please fill all the fields", Toast.LENGTH_SHORT).show();
        } else {
            Cursor cursor = myDb.LogUser(LogInMail.getText().toString(), LogInPassword.getText().toString());
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                String emailAddress = cursor.getString(0);
                String Pseudo = cursor.getString(2);
                byte[] Avatar = cursor.getBlob(3);
                Toast.makeText(LoginPage.this, "the user" + " " + Pseudo + " " + " is now log", Toast.LENGTH_SHORT).show();
                User user = new User(emailAddress, Pseudo, Avatar, "salam");
                cursor.close();
                Intent intent = new Intent(LoginPage.this, MainActivity.class);
                intent.putExtra("user", user);
                LoginPage.this.startActivity(intent);
                startActivity(intent);
            } else {
                Toast.makeText(LoginPage.this, "the user or password are not right", Toast.LENGTH_SHORT).show();
            }
        }
    }
}