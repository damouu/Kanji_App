package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Historic_Activity extends AppCompatActivity {
    private static ArrayList<UserTestHistory> LesTestHistoryUsers;
    public ArrayList<String> arrayList2;
    private static RemoteAccess remoteAccess;
    User user;
    Button Home_Button;
    ArrayAdapter adapter;
    TextView Historic_View;
    Button getTestButton;
    ListView Historic_ListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historic_);
        LesTestHistoryUsers = new ArrayList<UserTestHistory>();
        remoteAccess = new RemoteAccess();
        remoteAccess.envoi("HistoryTest", new JSONArray());
        arrayList2 = new ArrayList<String>();
        Home_Button = findViewById(R.id.Home_Button);
        getTestButton = findViewById(R.id.getTestButton);
        Historic_View = findViewById(R.id.Historic_View);
        Historic_ListView = findViewById(R.id.Historic_ListView);
        user = (User) getIntent().getSerializableExtra("user");
        Historic_View.setText("Your results historic " + user.getPseudo());
        LesTestHistoryUsers.size();
    }

    public void getTestButton(View v) {
        for (UserTestHistory userTestHistory : LesTestHistoryUsers) {
            if (userTestHistory.getEmailAddress().equals(user.getEmailAddress())) {
                arrayList2.add(userTestHistory.getNiveauJLPTTestKanji());
                arrayList2.add(userTestHistory.getDateTest());
                arrayList2.add(String.valueOf(userTestHistory.getScore()));
            } else {
                Toast.makeText(Historic_Activity.this, "You have not passed any test", Toast.LENGTH_SHORT).show();
            }
        }
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList2);
        Historic_ListView.setAdapter(adapter);
    }

    public void Home_Button1(View v) {
        Intent intent = new Intent(Historic_Activity.this, MainActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    public static ArrayList<UserTestHistory> getLesTestHistoryUsers() {
        return LesTestHistoryUsers;
    }

    public static void setLesTestHistoryUsers(ArrayList<UserTestHistory> lesTestHistoryUsers) {
        LesTestHistoryUsers = lesTestHistoryUsers;
    }
}
