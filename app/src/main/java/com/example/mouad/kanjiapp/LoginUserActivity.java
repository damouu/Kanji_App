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

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginUserActivity extends AppCompatActivity implements Serializable {
    DataBaseHelper myDb;
    private static DistantAccess distantAccess;
    private static ArrayList<UserDistant> LesUserDistants;
    Toolbar toolbar;
    Button LogInButton;
    TextView LogInMail;
    TextView LogInPassword;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        distantAccess = new DistantAccess();
        distantAccess.envoi("LogUser", new JSONArray());
        myDb = new DataBaseHelper(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LogInButton = findViewById(R.id.LogInButton);
        LogInMail = findViewById(R.id.LogInMail);
        LogInPassword = findViewById(R.id.LogInPassword);
        LogInMail.getText();
        LogInPassword.getText();
    }

    public void LogInButton(View v) {
        LogInMail.getText();
        LogInPassword.getText();
        if (LogInMail.getText().toString().trim().length() == 0 || LogInPassword.getText().toString().trim().length() == 0) {
            Toast.makeText(LoginUserActivity.this, "please fill all the fields", Toast.LENGTH_SHORT).show();
        } else {
            for (UserDistant userDistant1 : LesUserDistants) {
                if (userDistant1.getEmailAddress().equals(LogInMail.getText().toString()) && userDistant1.getPassword().equals(LogInPassword.getText().toString())) {
                    counter++;
                } else {

                }
            }
            if (counter == 0) {
                Toast.makeText(LoginUserActivity.this, "Invalid email or password.", Toast.LENGTH_SHORT).show();
            } else {
                Cursor cursor = myDb.LogUser(LogInMail.getText().toString(), LogInPassword.getText().toString());
                cursor.moveToFirst();
                String emailAddress = cursor.getString(0);
                String password = cursor.getString(1);
                String Pseudo = cursor.getString(2);
                byte[] Avatar = cursor.getBlob(3);
                Toast.makeText(LoginUserActivity.this, "The user" + " " + Pseudo + " " + " is now log.", Toast.LENGTH_SHORT).show();
                User user = new User(emailAddress, password, Pseudo, Avatar);
                cursor.close();
                Intent intent = new Intent(LoginUserActivity.this, MainActivity.class);
                intent.putExtra("user", user);
                LoginUserActivity.this.startActivity(intent);
                startActivity(intent);
            }
        }
    }

    public static ArrayList<UserDistant> getLesUserDistants() { return LesUserDistants; }


    public static void setLesUserDistants(ArrayList<UserDistant> lesUserDistants) { LesUserDistants = lesUserDistants; }
}