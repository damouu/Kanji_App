package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Lesson_Kanji extends AppCompatActivity {
    List<Kanji> Leskanjis = new ArrayList<Kanji>();
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
        String niveauJLPT = getIntent().getExtras().getString("niveauJLPT");
        textView2.setText(niveauJLPT);
        Bundle bundle = getIntent().getExtras();
        Leskanjis = (ArrayList) getIntent().getSerializableExtra("Leskanjis");
        textView3.setText(Leskanjis.get(i).getCharactere());
        textView4.setText(Leskanjis.get(i).getLecture_kenyon());
        textView5.setText(Leskanjis.get(i).getLecture_onyomi());
        textView6.setText(Leskanjis.get(i).getSignification());
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
                textView3.setText(Leskanjis.get(i).getCharactere());
                textView4.setText(Leskanjis.get(i).getLecture_kenyon());
                textView5.setText(Leskanjis.get(i).getLecture_onyomi());
                textView6.setText(Leskanjis.get(i).getSignification());
                break;
            }
        }
    }
}
