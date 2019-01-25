package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mouad on 26/12/2017.
 */

public class SecondScreen extends AppCompatActivity {
    ArrayList<Kanji> Leskanjis = new ArrayList<Kanji>();
    List<String> fauxkanjis = new ArrayList<String>();
    DataBaseHelper myDb;
    boolean reponse = false;
    int i = 0;
    int score = 0;
    String niveauJLPT;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivities);
        myDb = new DataBaseHelper(this);
        user = (User) getIntent().getSerializableExtra("user");
        niveauJLPT = getIntent().getExtras().getString("niveauJLPT");
        TextView JLPTView = (findViewById(R.id.JLPTView));
        TextView textView9 = (findViewById(R.id.textView9));
        JLPTView.setText(niveauJLPT);
        Bundle bundle = getIntent().getExtras();
        Leskanjis = (ArrayList) getIntent().getSerializableExtra("Leskanjis");
        TextView textView5 = findViewById(R.id.ryu_view);
        TextView ryuedit = findViewById(R.id.ryu_edit);
        ryuedit.setText(Leskanjis.get(i).getCharactere());
        textView5.setText(Leskanjis.get(i).getCharactere());
    }

    public void buttonOnClick4(View v) {
        TextView textView5 = findViewById(R.id.ryu_view);
        Button button = findViewById(R.id.button4);
        EditText editText5 = findViewById(R.id.ryu_edit);
        reponse = false;
        if (Arrays.asList(Leskanjis).contains(textView5.getText())) {
        }
        for (Kanji kanji : Leskanjis) {
            if (!editText5.getText().toString().equals(Leskanjis.get(i).getSignification())) {
                fauxkanjis.add(Leskanjis.get(i).getCharactere());
            } else {
                reponse = true;
                score++;
            }
            editText5.setText("");
            i++;
            if (i == Leskanjis.size()) {
                Intent intent = new Intent(SecondScreen.this, ThirdActivity.class);
                intent.putExtra("score", score);
                intent.putExtra("fauxkanjis", (ArrayList<String>) fauxkanjis);
                intent.putExtra("user", user);
                intent.putExtra("test.size", Leskanjis.size());
                myDb.InsertTest(niveauJLPT, score, user.GetEmailAddress());
                SecondScreen.this.startActivity(intent);
                break;
            }
            textView5.setText(Leskanjis.get(i).getCharactere());
            break;
        }
    }
}





