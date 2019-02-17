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
    TextView textView2;
    Button button2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    Cursor CheckFavoriteKanji;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson__kanji);
        button2 = findViewById(R.id.button2);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        user = (User) getIntent().getSerializableExtra("user");
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton3);
        String niveauJLPT = getIntent().getExtras().getString("niveauJLPT");
        textView2.setText(niveauJLPT);
        Bundle bundle = getIntent().getExtras();
        Leskanjis = (ArrayList) getIntent().getSerializableExtra("Leskanjis");
        textView3.setText(Leskanjis.get(i).getCharactere());
        textView4.setText(Leskanjis.get(i).getLecture_kenyon());
        textView5.setText(Leskanjis.get(i).getLecture_onyomi());
        textView6.setText(Leskanjis.get(i).getSignification());
       // CheckFavoriteKanji = myDb.CheckFavoriteKanji(Leskanjis.get(i).getCharactere(), user.getPseudo());
        /*if (CheckFavoriteKanji.getCount() > 0) {
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
        */
    }


    public void buttonOnClick2(View v) {
        for (Kanji kanji : Leskanjis) {
            i++;
            if (i == Leskanjis.size()) {
                Intent intent = new Intent(Lesson_Kanji.this, Learn_Kanji.class);
                Lesson_Kanji.this.startActivity(intent);
                break;
            } else {
/*                CheckFavoriteKanji = myDb.CheckFavoriteKanji(Leskanjis.get(i).getCharactere(), user.getPseudo());
                if (CheckFavoriteKanji.getCount() > 0) {
                    toggleButton.setChecked(true);
                } else {
                    toggleButton.setChecked(false);
                }*/
                textView3.setText(Leskanjis.get(i).getCharactere());
                textView4.setText(Leskanjis.get(i).getLecture_kenyon());
                textView5.setText(Leskanjis.get(i).getLecture_onyomi());
                textView6.setText(Leskanjis.get(i).getSignification());
                break;
            }
        }
    }
}
