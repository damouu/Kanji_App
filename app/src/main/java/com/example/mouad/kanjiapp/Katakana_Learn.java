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

public class Katakana_Learn extends AppCompatActivity {
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
        setContentView(R.layout.activity_katakana__learn);
        Button buttonHome = findViewById(R.id.button_Home);
        ListView listView = (ListView) findViewById(R.id.Historic_ListView);
        final String[] LesKatakanas = new String[]{"a", "Ka", "Sa", "Ta", "Na","Ha","Ma","Ra","Ya","Wa","N"};
        final ArrayList<Katakana> Katakana_A = new ArrayList<Katakana>();
        final ArrayList<Katakana> Katakana_Ka = new ArrayList<Katakana>();
        final ArrayList<Katakana> Hiragana_Sa = new ArrayList<Katakana>();
        final ArrayList<Katakana> Hiragana_Ta = new ArrayList<Katakana>();
        final ArrayList<Katakana> Hiragana_Na = new ArrayList<Katakana>();
        final ArrayList<Katakana> Hiragana_Ha = new ArrayList<Katakana>();
        final ArrayList<Katakana> Hiragana_Ma = new ArrayList<Katakana>();
        final ArrayList<Katakana> Hiragana_Ra = new ArrayList<Katakana>();
        final ArrayList<Katakana> Hiragana_Ya = new ArrayList<Katakana>();
        final ArrayList<Katakana> Hiragana_Wa = new ArrayList<Katakana>();
        final ArrayList<Katakana> Hiragana_N = new ArrayList<Katakana>();
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
        final String niveauKatakana = LesKatakanas[0];
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, LesKatakanas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "toozoumouk", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Katakana_Learn.this, MainActivity.class);
                String niveauKatakana = LesKatakanas[0];
                switch (position) {
                    case 0:
                        position = 0;
                        Cursor cursor = myDb.get_Katakana_A();
                        while (cursor.moveToNext()) {
                            Katakana_A.add(new Katakana(cursor.getString(cursor.getColumnIndex("CHARACTERE")), cursor.getInt(cursor.getColumnIndex("NUMERO")), cursor.getString(cursor.getColumnIndex("SIGNIFICATION"))));
                        }
                        if (Katakana_A.isEmpty()){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Katakana_Learn.this);
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
                            niveauKatakana = LesKatakanas[0];
                            intent = new Intent(Katakana_Learn.this, Katakana_Lesson.class);
                            intent.putExtra("niveauKatakana", niveauKatakana);
                            intent.putExtra("LesKatakanas", Katakana_A);
                            Katakana_Learn.this.startActivity(intent);
                            break;
                        }


                    case 1:
                        position = 1;
                        Cursor cursor2 = myDb2.get_Katakana_Ka();
                        while (cursor2.moveToNext()) {
                            Katakana_Ka.add(new Katakana(cursor2.getString(cursor2.getColumnIndex("CHARACTERE")), cursor2.getInt(cursor2.getColumnIndex("NUMERO")), cursor2.getString(cursor2.getColumnIndex("SIGNIFICATION"))));
                        }
                        if (Katakana_Ka.isEmpty()){
                            AlertDialog.Builder builder = new AlertDialog.Builder(Katakana_Learn.this);
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
                            niveauKatakana = LesKatakanas[1];
                            intent = new Intent(Katakana_Learn.this, Katakana_Lesson.class);
                            intent.putExtra("niveauKatakana", niveauKatakana);
                            intent.putExtra("LesKatakanas", Katakana_Ka);
                            Katakana_Learn.this.startActivity(intent);
                            break;
                        }
                }

            }
        });
    }
}
