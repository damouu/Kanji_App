package com.example.mouad.kanjiapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    DataBaseHelper myDb3;
    DataBaseHelper myDb4;
    DataBaseHelper myDb5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before__second_screen);
        Button buttonHome = findViewById(R.id.button_Home);
        ListView listView = (ListView) findViewById(R.id.ListView);
        final ArrayList<Kanji> Kanji_JLPT5 = new ArrayList<Kanji>();
        final ArrayList<Kanji> Kanji_JLPT4 = new ArrayList<Kanji>();
        final ArrayList<Kanji> Kanji_JLPT3 = new ArrayList<Kanji>();
        final ArrayList<Kanji> Kanji_JLPT2 = new ArrayList<Kanji>();
        final ArrayList<Kanji> Kanji_JLPT1 = new ArrayList<Kanji>();
        final String[] leskanjis = new String[]{"JLPT5", "JLPT4", "JLPT3", "JLPT2", "JLPT1"};
        final String niveauJLPT = leskanjis[0];
        myDb = new DataBaseHelper(this);
        myDb2 = new DataBaseHelper(this);
        myDb3 = new DataBaseHelper(this);
        myDb4 = new DataBaseHelper(this);
        myDb5 = new DataBaseHelper(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, leskanjis);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "chargement", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                String niveauJLPT = leskanjis[0];
                switch (position) {
                    case 0:
                        position = 0;
                        Cursor cursor = myDb.JLPT5_Kanji();
                        while (cursor.moveToNext()) {
                            Kanji_JLPT5.add(new Kanji(cursor.getString(cursor.getColumnIndex("CHARACTERE")), cursor.getInt(cursor.getColumnIndex("NUMERO")), cursor.getString(cursor.getColumnIndex("SIGNIFICATION")), cursor.getString(cursor.getColumnIndex("LECTURE_KUN")), cursor.getString(cursor.getColumnIndex("LECTURE_ON"))));
                        }
                        if (Kanji_JLPT5.isEmpty()){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Before_SecondScreen.this);
                            builder.setCancelable(true);
                            builder.setTitle("Alerte");
                            builder.setMessage("Le Niveau selectionné ne contient pas de Kanji ");
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
                            niveauJLPT = leskanjis[0];
                            intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                            intent.putExtra("niveauJLPT", niveauJLPT);
                            intent.putExtra("Leskanjis", Kanji_JLPT5);
                            Before_SecondScreen.this.startActivity(intent);
                            break;
                        }

                    case 1:
                        position = 1;
                        Cursor cursor2 = myDb2.JLPT4_Kanji();
                        while (cursor2.moveToNext()) {
                            Kanji_JLPT4.add(new Kanji(cursor2.getString(cursor2.getColumnIndex("CHARACTERE")), cursor2.getInt(cursor2.getColumnIndex("NUMERO")), cursor2.getString(cursor2.getColumnIndex("SIGNIFICATION")), cursor2.getString(cursor2.getColumnIndex("LECTURE_KUN")), cursor2.getString(cursor2.getColumnIndex("LECTURE_ON"))));
                        }
                        if (Kanji_JLPT4.isEmpty()){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Before_SecondScreen.this);
                            builder.setCancelable(true);
                            builder.setTitle("Alerte");
                            builder.setMessage("Le Niveau selectionné ne contient pas de Kanji ");
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
                            niveauJLPT = leskanjis[1];
                            intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                            intent.putExtra("niveauJLPT", niveauJLPT);
                            intent.putExtra("Leskanjis", Kanji_JLPT4);
                            Before_SecondScreen.this.startActivity(intent);
                            break;
                        }
                    case 2:
                        position = 2;
                        Cursor cursor3 = myDb3.JLPT3_Kanji();
                        while (cursor3.moveToNext()) {
                            Kanji_JLPT3.add(new Kanji(cursor3.getString(cursor3.getColumnIndex("CHARACTERE")), cursor3.getInt(cursor3.getColumnIndex("NUMERO")), cursor3.getString(cursor3.getColumnIndex("SIGNIFICATION")), cursor3.getString(cursor3.getColumnIndex("LECTURE_KUN")), cursor3.getString(cursor3.getColumnIndex("LECTURE_ON"))));
                        }
                        if (Kanji_JLPT3.isEmpty()){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Before_SecondScreen.this);
                            builder.setCancelable(true);
                            builder.setTitle("Alerte");
                            builder.setMessage("Le Niveau selectionné ne contient pas de Kanji ");
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
                            niveauJLPT = leskanjis[2];
                            intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                            intent.putExtra("niveauJLPT", niveauJLPT);
                            intent.putExtra("Leskanjis", Kanji_JLPT3);
                            Before_SecondScreen.this.startActivity(intent);
                            break;
                        }
                    case 3:
                        position = 3;
                        Cursor cursor4 = myDb4.JLPT2_Kanji();
                        while (cursor4.moveToNext()) {
                            Kanji_JLPT2.add(new Kanji(cursor4.getString(cursor4.getColumnIndex("CHARACTERE")), cursor4.getInt(cursor4.getColumnIndex("NUMERO")), cursor4.getString(cursor4.getColumnIndex("SIGNIFICATION")), cursor4.getString(cursor4.getColumnIndex("LECTURE_KUN")), cursor4.getString(cursor4.getColumnIndex("LECTURE_ON"))));
                        }
                        if (Kanji_JLPT2.isEmpty()){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Before_SecondScreen.this);
                            builder.setCancelable(true);
                            builder.setTitle("Alerte");
                            builder.setMessage("Le Niveau selectionné ne contient pas de Kanji ");
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
                            niveauJLPT = leskanjis[3];
                            intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                            intent.putExtra("niveauJLPT", niveauJLPT);
                            intent.putExtra("Leskanjis", Kanji_JLPT2);
                            Before_SecondScreen.this.startActivity(intent);
                            break;
                        }

                    case 4:
                        position = 4;
                        Cursor cursor5 = myDb5.JLPT1_Kanji();
                        while (cursor5.moveToNext()) {
                            Kanji_JLPT1.add(new Kanji(cursor5.getString(cursor5.getColumnIndex("CHARACTERE")), cursor5.getInt(cursor5.getColumnIndex("NUMERO")), cursor5.getString(cursor5.getColumnIndex("SIGNIFICATION")), cursor5.getString(cursor5.getColumnIndex("LECTURE_KUN")), cursor5.getString(cursor5.getColumnIndex("LECTURE_ON"))));
                        }
                        if (Kanji_JLPT1.isEmpty()){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Before_SecondScreen.this);
                            builder.setCancelable(true);
                            builder.setTitle("Alerte");
                            builder.setMessage("Le Niveau selectionné ne contient pas de Kanji ");
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
                            niveauJLPT = leskanjis[4];
                            intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                            intent.putExtra("niveauJLPT", niveauJLPT);
                            intent.putExtra("Leskanjis", Kanji_JLPT1);
                            Before_SecondScreen.this.startActivity(intent);
                            break;
                        }
                    case 5:
                        position = 5;
                        niveauJLPT = leskanjis[5];
                        intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                        intent.putExtra("niveauJLPT", niveauJLPT);
                        Before_SecondScreen.this.startActivity(intent);
                        break;
                }

            }

        });
    }
    public void button_Home(View v) {
        Button button_Home = findViewById(R.id.button_Home);
        button_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Before_SecondScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}