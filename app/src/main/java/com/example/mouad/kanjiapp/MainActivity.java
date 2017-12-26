package com.example.mouad.kanjiapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    TextView ChampText;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonOnClick1 (View v)
    {
        Button Click = (Button) findViewById(R.id.button);
        EditText editText = (EditText) findViewById(R.id.editText2);
        TextView ChampText = (TextView) findViewById(R.id.textView);
        ChampText.setText(editText.getText());
        ((Button)v).setText("salam");
        Click.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.i("My app" , "do the magic");
                Toast.makeText(getApplicationContext(), "button has been Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void buttonOnClick2 (View v)
    {
        EditText editText = (EditText) findViewById(R.id.editText2);
        TextView ChampText = (TextView) findViewById(R.id.textView);
        ChampText.setText(editText.getText());
        ImageButton Damou_Button = (ImageButton) findViewById(R.id.Damou_Button);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Alerte");
        builder.setMessage("MASHALLAH ");
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener()

        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                dialogInterface.cancel();
                Log.i("GG","do the shit");
                Toast.makeText(getApplicationContext(), "my god !",Toast.LENGTH_SHORT).show();
            }

        });
        builder.show();
    }
}

