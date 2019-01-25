package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.database.Cursor;
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

import java.util.ArrayList;

public class Historic_Activity extends AppCompatActivity {
    User user;
    DataBaseHelper myDb;
    Cursor cursor;
    Button Home_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historic_);
        Button Home = findViewById(R.id.Home_Button);
        TextView Historic_View = findViewById(R.id.Historic_View);
        ListView Historic_ListView = findViewById(R.id.Historic_ListView);
        myDb = new DataBaseHelper(this);
        user = (User) getIntent().getSerializableExtra("user");
        cursor = myDb.GetUserHistoric(user.GetEmailAddress());
        if (cursor.getCount() > 0) {
            ArrayList<String> mArrayList = new ArrayList<String>();
            while (cursor.moveToNext()) {
                mArrayList.add(cursor.getString(cursor.getColumnIndex("NIVEAU_JLPT_TEST_KANJI")));
                mArrayList.add(cursor.getString(cursor.getColumnIndex("DATE_TEST")));
                mArrayList.add(cursor.getString(cursor.getColumnIndex("SCORE")));
            }
            cursor.close();
            ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mArrayList);
            Historic_ListView.setAdapter(adapter);
            Historic_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 3) {
                        Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "You still haven't passed a test !", Toast.LENGTH_LONG).show();
        }
        //SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,null,new String[]{String.valueOf(myDb.GetUserHistoric(user.GetEmailAddress()))},new int[]{android.R.id.list_container});
    }

    public void Home_Button1(View v) {
        Button Home_Button = findViewById(R.id.Home_Button);
        Intent intent = new Intent(Historic_Activity.this, MainActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }
}
