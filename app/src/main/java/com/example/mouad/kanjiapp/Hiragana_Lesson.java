package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Hiragana_Lesson extends AppCompatActivity {
    List<Hiragana> Leshiraganas = new ArrayList<Hiragana>();
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana__lesson);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        Button button2 = (Button) findViewById(R.id.button2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        String niveauJLPT = getIntent().getExtras().getString("niveauHiragana");
        textView2.setText(niveauJLPT);
        Bundle bundle = getIntent().getExtras();
        Leshiraganas = (ArrayList) getIntent().getSerializableExtra("LesHiraganas");
        textView3.setText(Leshiraganas.get(i).getCharactere());
        textView6.setText(Leshiraganas.get(i).getSignification());
    }

    public void buttonOnClick2(View v) {
        Button button2 = findViewById(R.id.button2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        for (Hiragana hiragana : Leshiraganas) {
            i++;
            if (i == Leshiraganas.size()) {
                Intent intent = new Intent(Hiragana_Lesson.this, Hiragana_beforeT.class);
                Hiragana_Lesson.this.startActivity(intent);
                break;
            } else {
                textView3.setText(Leshiraganas.get(i).getCharactere());
                textView6.setText(Leshiraganas.get(i).getSignification());
                break;
            }
        }
    }
}
