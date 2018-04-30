package com.example.mouad.kanjiapp;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mouad on 26/12/2017.
 */

public class SecondScreen extends AppCompatActivity
{
    ArrayList<Kanji> Leskanjis = new ArrayList<Kanji>();
    List<String> fauxkanjis = new ArrayList<String>();
    DataBaseHelper myDb;
    boolean reponse = false;
    int i = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivities);
        myDb = new DataBaseHelper(this);
        String niveauJLPT = getIntent().getExtras().getString("niveauJLPT");
      //  textView2.setText(niveauJLPT);
        Bundle bundle = getIntent().getExtras();
        Leskanjis = (ArrayList) getIntent().getSerializableExtra("Leskanjis");
        TextView textView5 = findViewById(R.id.ryu_view);
        textView5.setText(Leskanjis.get(i).getCharactere());
    }

    public void buttonOnClick3 (View v)
     {
        ImageButton personaButton = findViewById(R.id.imageButton);
        personaButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
     }

        public void buttonOnClick4 (View v)
    {
        TextView ScoreView = findViewById(R.id.ScoreView);
        EditText editText3 = findViewById(R.id.editText3);
        TextView textView5 = findViewById(R.id.ryu_view);
        Button button = findViewById(R.id.button4);
        EditText editText5 = findViewById(R.id.ryu_edit);
        reponse = false;
        if(Arrays.asList(Leskanjis).contains(textView5.getText())){
        }
        for(Kanji kanji : Leskanjis){
            if (!editText5.getText().toString().equals(Leskanjis.get(i).getSignification())){
                fauxkanjis.add(Leskanjis.get(i).getCharactere());
            }
            else {
                reponse=true;
                score++;
                ScoreView.setText(String.valueOf(score));
            }
            editText5.setText("");
            i++;
            if (i==Leskanjis.size()){
                Intent intent = new Intent(SecondScreen.this, ThirdActivity.class);
                intent.putExtra("score", score);
                intent.putExtra("fauxkanjis", (ArrayList<String>) fauxkanjis);
                SecondScreen.this.startActivity(intent);
                break;
            }
            textView5.setText(Leskanjis.get(i).getCharactere());
            break;
            }
    }
}





