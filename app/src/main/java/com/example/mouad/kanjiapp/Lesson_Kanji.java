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
    List<Kanji> LeskanjisJLPT5 = new ArrayList<Kanji>();
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
        LeskanjisJLPT5 = (ArrayList) getIntent().getSerializableExtra("LeskanjisJLPT5");
        textView3.setText(LeskanjisJLPT5.get(i).getCharactere());
        textView4.setText(LeskanjisJLPT5.get(i).getLecture_kenyon());
        textView5.setText(LeskanjisJLPT5.get(i).getLecture_onyomi());
        textView6.setText(LeskanjisJLPT5.get(i).getSignification());
    }

    public void buttonOnClick2(View v) {
        Button button2 = findViewById(R.id.button2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        TextView textView6 = (TextView) findViewById(R.id.textView6);

        for (Kanji kanji : LeskanjisJLPT5) {
            i++;
            if (i == LeskanjisJLPT5.size()) {
                Intent intent = new Intent(Lesson_Kanji.this, Learn_Kanji.class);
                Lesson_Kanji.this.startActivity(intent);
                break;
            } else {
                textView3.setText(LeskanjisJLPT5.get(i).getCharactere());
                textView4.setText(LeskanjisJLPT5.get(i).getLecture_kenyon());
                textView5.setText(LeskanjisJLPT5.get(i).getLecture_onyomi());
                textView6.setText(LeskanjisJLPT5.get(i).getSignification());
                break;
            }
        }
    }
}
