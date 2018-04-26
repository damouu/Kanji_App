package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Learn_Kanji extends AppCompatActivity {
    ArrayList<Kanji> LeskanjisJLPT5   = new ArrayList<Kanji>();
    Kanji manger = new Kanji("食",0,"manger","taberu","shiyoku");
    Kanji lire   = new Kanji("読",1,"lire","yomu","doku");
    Kanji boire  = new Kanji("飲",2,"boire","nomu","in");
    Kanji entrer = new Kanji("入",3,"entrer","iru","niyou");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Hiragana bilal = new Hiragana("か",1,"ka");
        Katakana nabil = new Katakana(" ア",2,"a");
        LeskanjisJLPT5.add(boire);
        LeskanjisJLPT5.add(manger);
        LeskanjisJLPT5.add(lire);
        LeskanjisJLPT5.add(entrer);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn__kanji);
        final String [] leskanjis = new String[] {"JLPT5","JLPT4","JLPT3","JLPT2","JLPT1"};
        final String niveauJLPT =  leskanjis[0];
        ListView listView = (ListView) findViewById(R.id.ListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,leskanjis);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"toozoumouk",Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0: position =0;
                        String niveauJLPT =  leskanjis[0];
                        Intent intent = new Intent(Learn_Kanji.this, Lesson_Kanji.class);
                        intent.putExtra("niveauJLPT", niveauJLPT);
                        intent.putExtra("LeskanjisJLPT5", LeskanjisJLPT5);
                        Learn_Kanji.this.startActivity(intent);
                        break;

                    case 1: position =1;
                        niveauJLPT = leskanjis[1];
                        intent = new Intent(Learn_Kanji.this, Lesson_Kanji.class);
                        intent.putExtra("niveauJLPT", niveauJLPT);
                        Learn_Kanji.this.startActivity(intent);
                        break;

                    case 2: position =2;
                        niveauJLPT = leskanjis[2];
                        intent = new Intent(Learn_Kanji.this, Lesson_Kanji.class);
                        intent.putExtra("niveauJLPT", niveauJLPT);
                        Learn_Kanji.this.startActivity(intent);
                        break;

                    case 3: position =3;
                        niveauJLPT = leskanjis[3];
                        intent = new Intent(Learn_Kanji.this, Lesson_Kanji.class);
                        intent.putExtra("niveauJLPT", niveauJLPT);
                        Learn_Kanji.this.startActivity(intent);
                        break;

                    case 4: position =4;
                        niveauJLPT = leskanjis[4];
                        intent = new Intent(Learn_Kanji.this, Lesson_Kanji.class);
                        intent.putExtra("niveauJLPT", niveauJLPT);
                        Learn_Kanji.this.startActivity(intent);
                        break;

                    case 5: position =5;
                        niveauJLPT = leskanjis[5];
                        intent = new Intent(Learn_Kanji.this, Lesson_Kanji.class);
                        intent.putExtra("niveauJLPT", niveauJLPT);
                        Learn_Kanji.this.startActivity(intent);
                        break;
                }
            }
        });
    }
}
