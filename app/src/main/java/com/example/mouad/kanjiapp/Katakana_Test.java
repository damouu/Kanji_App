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

public class Katakana_Test extends AppCompatActivity {
    ArrayList<Katakana> LesKatakanas = new ArrayList<Katakana>();
    List<String> KatakanaFaux = new ArrayList<String>();
    DataBaseHelper myDb;
    boolean reponse = false;
    int i = 0;
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katakana__test);
        myDb = new DataBaseHelper(this);
        String niveauKatakana = getIntent().getExtras().getString("niveauKatakana");
        TextView JLPTView = (findViewById(R.id.JLPTView));
        TextView textView9 = (findViewById(R.id.textView9));
        JLPTView.setText(niveauKatakana);
        Bundle bundle = getIntent().getExtras();
        LesKatakanas = (ArrayList) getIntent().getSerializableExtra("LesKatakanas");
        TextView textView5 = findViewById(R.id.ryu_view);
        TextView ryuedit = findViewById(R.id.ryu_edit);
        ryuedit.setText(LesKatakanas.get(i).getCharactere());
        textView5.setText(LesKatakanas.get(i).getCharactere());
    }

    public void buttonOnClick4(View v) {
        TextView textView5 = findViewById(R.id.ryu_view);
        Button button = findViewById(R.id.button4);
        EditText editText5 = findViewById(R.id.ryu_edit);
        reponse = false;
        if (Arrays.asList(LesKatakanas).contains(textView5.getText())) {
        }
        for (Katakana katakana : LesKatakanas) {
            if (!editText5.getText().toString().equals(LesKatakanas.get(i).getSignification())) {
                KatakanaFaux.add(LesKatakanas.get(i).getCharactere());
            } else {
                reponse = true;
                score++;
            }
            editText5.setText("");
            i++;
            if (i == LesKatakanas.size()) {
                Intent intent = new Intent(Katakana_Test.this, Katakana_Results.class);
                intent.putExtra("score", score);
                intent.putExtra("KatakanaFaux", (ArrayList<String>) KatakanaFaux);
                Katakana_Test.this.startActivity(intent);
                break;
            }
            textView5.setText(LesKatakanas.get(i).getCharactere());
            break;
        }
    }
}


