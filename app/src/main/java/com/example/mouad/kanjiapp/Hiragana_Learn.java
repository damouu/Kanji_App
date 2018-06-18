package com.example.mouad.kanjiapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Hiragana_Learn extends AppCompatActivity {
    DataBaseHelper myDb;
    DataBaseHelper myDb2;
    DataBaseHelper myDb3;
    DataBaseHelper myDb4;
    DataBaseHelper myDb5;
    DataBaseHelper myDb6;
    DataBaseHelper myDb7;
    DataBaseHelper myDb8;
    DataBaseHelper myDb9;
    DataBaseHelper myDb10;
    DataBaseHelper myDb11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana__learn);
        Button buttonHome = findViewById(R.id.button_Home);
        ListView listView = (ListView) findViewById(R.id.ListView);
        final String[] LesHiraganas = new String[]{"a", "Ka", "Sa", "Ta", "Na","Ha","Ma","Ra","Ya","Wa","N"};
        final ArrayList<Hiragana> Hiragana_A = new ArrayList<Hiragana>();
        final ArrayList<Hiragana> Hiragana_Ka = new ArrayList<Hiragana>();
        final ArrayList<Kanji> Hiragana_Sa = new ArrayList<Kanji>();
        final ArrayList<Kanji> Hiragana_Ta = new ArrayList<Kanji>();
        final ArrayList<Kanji> Hiragana_Na = new ArrayList<Kanji>();
        final ArrayList<Kanji> Hiragana_Ha = new ArrayList<Kanji>();
        final ArrayList<Kanji> Hiragana_Ma = new ArrayList<Kanji>();
        final ArrayList<Kanji> Hiragana_Ra = new ArrayList<Kanji>();
        final ArrayList<Kanji> Hiragana_Ya = new ArrayList<Kanji>();
        final ArrayList<Kanji> Hiragana_Wa = new ArrayList<Kanji>();
        final ArrayList<Kanji> Hiragana_N = new ArrayList<Kanji>();
        myDb  = new DataBaseHelper(this);
        myDb2 = new DataBaseHelper(this);
        myDb3 = new DataBaseHelper(this);
        myDb4 = new DataBaseHelper(this);
        myDb5 = new DataBaseHelper(this);
        myDb6  = new DataBaseHelper(this);
        myDb7 = new DataBaseHelper(this);
        myDb8 = new DataBaseHelper(this);
        myDb9 = new DataBaseHelper(this);
        myDb10 = new DataBaseHelper(this);
        myDb11 = new DataBaseHelper(this);
        final String niveauHiragana = LesHiraganas[0];
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, LesHiraganas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "chargement", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Hiragana_Learn.this, MainActivity.class);
                String niveauHiragana = LesHiraganas[0];
                switch (position) {
                    case 0:
                        position = 0;
                        Cursor cursor = myDb.get_Hiragana_A();
                        while (cursor.moveToNext()) {
                            Hiragana_A.add(new Hiragana(cursor.getString(cursor.getColumnIndex("CHARACTERE")), cursor.getInt(cursor.getColumnIndex("NUMERO")), cursor.getString(cursor.getColumnIndex("SIGNIFICATION"))));
                        }
                        if (Hiragana_A.isEmpty()){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Hiragana_Learn.this);
                            builder.setCancelable(true);
                            builder.setTitle("Alerte");
                            builder.setMessage("Le Niveau selectionné ne contient pas de Hiragana ");
                            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i)
                                {
                                    dialogInterface.cancel();
                                }
                            });
                            builder.show();
                            break;
                        }
                        else
                        {
                            niveauHiragana = LesHiraganas[0];
                            intent = new Intent(Hiragana_Learn.this, Hiragana_Lesson.class);
                            intent.putExtra("niveauHiragana", niveauHiragana);
                            intent.putExtra("LesHiraganas", Hiragana_A);
                            Hiragana_Learn.this.startActivity(intent);
                            break;
                        }


                    case 1:
                        position = 1;
                        Cursor cursor2 = myDb2.get_Hiragana_Ka();
                        while (cursor2.moveToNext()) {
                            Hiragana_Ka.add(new Hiragana(cursor2.getString(cursor2.getColumnIndex("CHARACTERE")), cursor2.getInt(cursor2.getColumnIndex("NUMERO")), cursor2.getString(cursor2.getColumnIndex("SIGNIFICATION"))));
                        }
                        if (Hiragana_Ka.isEmpty()){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Hiragana_Learn.this);
                            builder.setCancelable(true);
                            builder.setTitle("Alerte");
                            builder.setMessage("Le Niveau selectionné ne contient pas de Hiragana ");
                            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i)
                                {
                                    dialogInterface.cancel();
                                }
                            });
                            builder.show();
                            break;
                        }
                        else
                        {
                            niveauHiragana = LesHiraganas[1];
                            intent = new Intent(Hiragana_Learn.this, Hiragana_Lesson.class);
                            intent.putExtra("niveauHiragana", niveauHiragana);
                            intent.putExtra("LesHiraganas", Hiragana_Ka);
                            Hiragana_Learn.this.startActivity(intent);
                            break;
                        }


                }

            }
        });
    }
}


