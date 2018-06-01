package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Katakana_Lesson extends AppCompatActivity {
    List<Katakana> Leskatakanas  = new ArrayList<Katakana>();
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katakana__lesson);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        Button button2 = (Button) findViewById(R.id.button2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        String niveauJLPT = getIntent().getExtras().getString("niveauKatakana");
        textView2.setText(niveauJLPT);
        Bundle bundle = getIntent().getExtras();
        Leskatakanas = (ArrayList) getIntent().getSerializableExtra("LesKatakanas");
        textView3.setText(Leskatakanas.get(i).getCharactere());
        textView6.setText(Leskatakanas.get(i).getSignification());
    }

    public void buttonOnClick2(View v) {
        Button button2 = findViewById(R.id.button2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        TextView textView6 = (TextView) findViewById(R.id.textView6);

        for (Katakana katakana : Leskatakanas) {
            i++;
            if (i == Leskatakanas.size()) {
                Intent intent = new Intent(Katakana_Lesson.this, Katakana_Learn.class);
                Katakana_Lesson.this.startActivity(intent);
                break;
            } else {
                textView3.setText(Leskatakanas.get(i).getCharactere());
                textView6.setText(Leskatakanas.get(i).getSignification());
                break;
            }
        }
    }
}

