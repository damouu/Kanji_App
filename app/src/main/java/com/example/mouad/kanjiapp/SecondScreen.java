package com.example.mouad.kanjiapp;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Created by mouad on 26/12/2017.
 */

public class SecondScreen extends AppCompatActivity
{
    List<Kanji> leskanjis = new ArrayList<>();
    Kanji manger = new Kanji("食",0,"dede","dede","manger");
    Kanji lire   = new Kanji("読",1,"dede","dede","lire");
    Kanji boire  = new Kanji("飲",2,"dede","dede","boire");
    boolean reponse;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivities);
        leskanjis.add(boire);
        leskanjis.add(manger);
        leskanjis.add(lire);
        TextView textView5 = (TextView) findViewById(R.id.ryu_view);
        textView5.setText(leskanjis.get(0).getKanji());
        reponse = false;


    }

    public void buttonOnClick3 (View v)
    {
        ImageButton personaButton = (ImageButton) findViewById(R.id.imageButton);
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
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);

        System.out.println("hello");
        TextView textView5 = (TextView) findViewById(R.id.ryu_view);
        Button button = (Button) findViewById(R.id.button4);
        EditText editText5 = (EditText) findViewById(R.id.ryu_edit);
        reponse = false;
        if(Arrays.asList(leskanjis).contains(textView5.getText())){

        }
        for (int i =0; i < leskanjis.size(); i++){
            if(editText5.getText().toString().equals(leskanjis.get(i).getSignification())) {
               editText5.setText("");
               textView5.setText(leskanjis.get(i+1).getKanji());
               break;
            }

            /*if(!editText5.getText().toString().trim().equals(leskanjis.get(0).getSignification()))
            {
                {
                    reponse = false;
                    AlertDialog.Builder builder = new AlertDialog.Builder(SecondScreen.this);
                    builder.setCancelable(true);
                    builder.setTitle("Alerte");
                    builder.setMessage("faux pas egale");
                    builder.setNegativeButton("cancel", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            dialogInterface.cancel();
                        }
                    });
                    builder.show();
                }
            }
            else
            {
                    leskanjis.get(0);
            }*/

        }


    }

}

       /* if(!editText5.getText().toString().trim().equals(leskanjis.get(0).getSignification()))
        {
            reponse = false;
            AlertDialog.Builder builder = new AlertDialog.Builder(SecondScreen.this);
            builder.setCancelable(true);
            builder.setTitle("Alerte");
            builder.setMessage("faux pas egale");
            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    dialogInterface.cancel();
                }
            });
            builder.show();
        }

        else
        {

        }*/

