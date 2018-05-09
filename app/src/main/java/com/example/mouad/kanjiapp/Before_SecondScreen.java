package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Before_SecondScreen extends AppCompatActivity {
    DataBaseHelper myDb;
    DataBaseHelper myDb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before__second_screen);
        Button buttonHome = findViewById(R.id.button_Home);
        ListView listView = (ListView) findViewById(R.id.ListView);
        final ArrayList<Kanji> Kanji_JLPT5 = new ArrayList<Kanji>();
        final ArrayList<Kanji> Kanji_JLPT4 = new ArrayList<Kanji>();
        final String [] leskanjis = new String[] {"JLPT5","JLPT4","JLPT3","JLPT2","JLPT1"};
        final String niveauJLPT =  leskanjis[0];
        myDb = new DataBaseHelper(this);
        myDb2 = new DataBaseHelper(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,leskanjis);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"toozoumouk",Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0: position =0;
                        Cursor cursor = myDb.JLPT5_Kanji();
                        while (cursor.moveToNext()){
                            Kanji_JLPT5.add(new Kanji(cursor.getString(cursor.getColumnIndex("CHARACTERE")), cursor.getInt(cursor.getColumnIndex("NUMERO")), cursor.getString(cursor.getColumnIndex("SIGNIFICATION")),cursor.getString(cursor.getColumnIndex("LECTURE_KUN")),cursor.getString(cursor.getColumnIndex("LECTURE_ON"))));
                        }
                        String niveauJLPT =  leskanjis[0];
                        Intent intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                        intent.putExtra("niveauJLPT", niveauJLPT);
                        intent.putExtra("Leskanjis", Kanji_JLPT5);
                        Before_SecondScreen.this.startActivity(intent);
                        break;

                    case 1: position =1;
                        Cursor cursor2 = myDb2.JLPT4_Kanji();
                        while (cursor2.moveToNext()){
                            Kanji_JLPT4.add(new Kanji(cursor2.getString(cursor2.getColumnIndex("CHARACTERE")), cursor2.getInt(cursor2.getColumnIndex("NUMERO")), cursor2.getString(cursor2.getColumnIndex("SIGNIFICATION")),cursor2.getString(cursor2.getColumnIndex("LECTURE_KUN")),cursor2.getString(cursor2.getColumnIndex("LECTURE_ON"))));
                        }
                        niveauJLPT = leskanjis[1];
                        intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                        intent.putExtra("niveauJLPT", niveauJLPT);
                        intent.putExtra("Leskanjis", Kanji_JLPT4);
                        Before_SecondScreen.this.startActivity(intent);
                        break;

                    case 2: position =2;
                        niveauJLPT = leskanjis[2];
                        intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                        intent.putExtra("niveauJLPT", niveauJLPT);
                        Before_SecondScreen.this.startActivity(intent);
                        break;

                    case 3: position =3;
                        niveauJLPT = leskanjis[3];
                        intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                        intent.putExtra("niveauJLPT", niveauJLPT);
                        Before_SecondScreen.this.startActivity(intent);
                        break;

                    case 4: position =4;
                        niveauJLPT = leskanjis[4];
                        intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                        intent.putExtra("niveauJLPT", niveauJLPT);
                        Before_SecondScreen.this.startActivity(intent);
                        break;

                    case 5: position =5;
                        niveauJLPT = leskanjis[5];
                        intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                        intent.putExtra("niveauJLPT", niveauJLPT);
                        Before_SecondScreen.this.startActivity(intent);
                        break;
                }
            }
        }); }
        }