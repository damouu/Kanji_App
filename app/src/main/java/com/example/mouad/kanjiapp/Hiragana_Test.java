package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hiragana_Test extends AppCompatActivity {
    ArrayList<Hiragana> LesHiraganas = new ArrayList<Hiragana>();
    List<String> HiraganaFaux = new ArrayList<String>();
    DataBaseHelper myDb;
    boolean reponse = false;
    int i = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana__test);
        myDb = new DataBaseHelper(this);
        String niveauHiragana = getIntent().getExtras().getString("niveauHiragana");
        TextView JLPTView = (findViewById(R.id.JLPTView));
        TextView textView9 = (findViewById(R.id.textView9));
        JLPTView.setText(niveauHiragana);
        Bundle bundle = getIntent().getExtras();
        LesHiraganas = (ArrayList) getIntent().getSerializableExtra("LesHiraganas");
        TextView textView5 = findViewById(R.id.ryu_view);
        TextView ryuedit = findViewById(R.id.ryu_edit);
        ryuedit.setText(LesHiraganas.get(i).getCharactere());
        textView5.setText(LesHiraganas.get(i).getCharactere());
    }


    public void buttonOnClick4 (View v)
    {
        TextView textView5 = findViewById(R.id.ryu_view);
        Button button = findViewById(R.id.button4);
        EditText editText5 = findViewById(R.id.ryu_edit);
        reponse = false;
        if(Arrays.asList(LesHiraganas).contains(textView5.getText())){
        }
        for(Hiragana hiragana : LesHiraganas){
            if (!editText5.getText().toString().equals(LesHiraganas.get(i).getSignification())){
                HiraganaFaux.add(LesHiraganas.get(i).getCharactere());
            }
            else {
                reponse=true;
                score++;
            }
            editText5.setText("");
            i++;
            if (i==LesHiraganas.size()){
                Intent intent = new Intent(Hiragana_Test.this, Hiragana_Results.class);
                intent.putExtra("score", score);
                intent.putExtra("HiraganaFaux", (ArrayList<String>) HiraganaFaux);
                Hiragana_Test.this.startActivity(intent);
                break;
            }
            textView5.setText(LesHiraganas.get(i).getCharactere());
            break;
        }
    }
}
