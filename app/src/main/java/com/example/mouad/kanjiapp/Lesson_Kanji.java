package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class Lesson_Kanji extends AppCompatActivity {
    List<Kanji> Leskanjis = new ArrayList<Kanji>();
    List<Kanji> Fauxkanjis = new ArrayList<Kanji>();
    ToggleButton toggleButton;
    User user;
    DataBaseHelper myDb;
    Cursor CheckFavoriteKanji;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson__kanji);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        Button button2 = (Button) findViewById(R.id.button2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        user = (User) getIntent().getSerializableExtra("user");
        myDb = new DataBaseHelper(this);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton3);
        String niveauJLPT = getIntent().getExtras().getString("niveauJLPT");
        textView2.setText(niveauJLPT);
        Bundle bundle = getIntent().getExtras();
        Leskanjis = (ArrayList) getIntent().getSerializableExtra("Leskanjis");
        textView3.setText(Leskanjis.get(i).getCharactere());
        textView4.setText(Leskanjis.get(i).getLecture_kenyon());
        textView5.setText(Leskanjis.get(i).getLecture_onyomi());
        textView6.setText(Leskanjis.get(i).getSignification());
        GetNbKanjis();
        CheckFavoriteKanji = myDb.CheckFavoriteKanji(Leskanjis.get(i).getCharactere(), user.getPseudo());
        if (CheckFavoriteKanji.getCount() > 0) {
            toggleButton.setChecked(true);
        } else {
            toggleButton.setChecked(false);
        }
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    CheckFavoriteKanji = myDb.CheckFavoriteKanji(Leskanjis.get(i).getCharactere(), user.getPseudo());
                    if (CheckFavoriteKanji.getCount() > 0) {
                        toggleButton.setChecked(true);
                    } else {
                        myDb.InsertFavoriteKanji(Leskanjis.get(i).getCharactere(), user.getPseudo());
                        Toast.makeText(Lesson_Kanji.this, "Kanji added to your favorite list", Toast.LENGTH_SHORT).show();
                        toggleButton.setChecked(true);
                    }
                } else {
                    toggleButton.setChecked(false);
                    myDb.DeleteFavoriteKanji(Leskanjis.get(i).getCharactere(), user.getPseudo());
                }
            }
        });
    }


    public int GetNbKanjis() {
        int NbKanjis = 0;
        for (Kanji kanji : Leskanjis) {
            NbKanjis++;
        }
        return NbKanjis;
    }

    public void SyncKanjis() {
        Kanji k = new Kanji("ded", 1, "dee", "dede", "dde");
        if (Leskanjis != Fauxkanjis) {
            k.getNumero();
        }
    }

    public void buttonOnClick2(View v) {
        Button button2 = findViewById(R.id.button2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        for (Kanji kanji : Leskanjis) {
            i++;
            if (i == Leskanjis.size()) {
                Intent intent = new Intent(Lesson_Kanji.this, Learn_Kanji.class);
                Lesson_Kanji.this.startActivity(intent);
                break;
            } else {
                CheckFavoriteKanji = myDb.CheckFavoriteKanji(Leskanjis.get(i).getCharactere(), user.getPseudo());
                if (CheckFavoriteKanji.getCount() > 0) {
                    toggleButton.setChecked(true);
                } else {
                    toggleButton.setChecked(false);
                }
                textView3.setText(Leskanjis.get(i).getCharactere());
                textView4.setText(Leskanjis.get(i).getLecture_kenyon());
                textView5.setText(Leskanjis.get(i).getLecture_onyomi());
                textView6.setText(Leskanjis.get(i).getSignification());
                break;
            }
        }
    }
}
