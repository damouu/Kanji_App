package com.example.mouad.kanjiapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Historic_Activity extends AppCompatActivity {
    User user;
    DataBaseHelper myDb;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historic_);
        Button Home = findViewById(R.id.Home);
        TextView Historic_View  = findViewById(R.id.Historic_View);
        ListView Historic_ListView  = findViewById(R.id.Historic_ListView);
        myDb = new DataBaseHelper(this);
        user = (User)getIntent().getSerializableExtra("user");
        cursor = myDb.GetUserHistoric(user.GetEmailAddress());
        ArrayList<String> mArrayList = new ArrayList<String>();
        while (cursor.moveToNext()){
            mArrayList.add(cursor.getString(cursor.getColumnIndex("NIVEAU_JLPT_TEST_KANJI")));
            mArrayList.add(cursor.getString(cursor.getColumnIndex("DATE_TEST")));
            mArrayList.add(cursor.getString(cursor.getColumnIndex("SCORE")));
        }
        cursor.close();
        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mArrayList);
        Historic_ListView.setAdapter(adapter);
        //SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,null,new String[]{String.valueOf(myDb.GetUserHistoric(user.GetEmailAddress()))},new int[]{android.R.id.list_container});
    }
}
