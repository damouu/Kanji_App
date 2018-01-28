package com.example.mouad.kanjiapp;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by mouad on 26/12/2017.
 */

public class SecondScreen extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivities);
    }

    public void buttonOnClick3 (View v) {
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
        Button button = (Button) findViewById(R.id.button4);
        EditText editText5 = (EditText) findViewById(R.id.ryu_edit);
        TextView textView5 = (TextView) findViewById(R.id.ryu_view);
        Kanji aller = new Kanji('行',1,"iku","bilal","aller");
        textView5.setText(aller.getSignification());
        if(!editText5.getText().toString().trim().equals(textView5.getText()))
        {
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

}
