package com.example.mouad.kanjiapp;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.nfc.Tag;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity
{
    DataBaseHelper myDb;
    TextView ChampText;
    EditText editText;
    Button ViewAll;
    EditText Time_TextView;
    private ActionBarDrawerToggle mToggle;
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DataBaseHelper(this);
        Button Admin_Button = findViewById(R.id.Admin_Button);
        Button button_KANJI = findViewById(R.id.button_KANJI);
        Button button_HIRAGANA = findViewById(R.id.button_HIRAGANA);
        Button button_KATAKANA = findViewById(R.id.button_KATAKANA);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        TextView Time_TextView = findViewById(R.id.Time_TextView);
        Time_TextView.setText(currentDateTimeString);
    }

    public void buttonOnClick3 (View v){
        ImageButton personaButton = findViewById(R.id.imageButton2);
        personaButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this , Before_SecondScreen.class);
                startActivity(intent);
            }
        });
    }

    public void personaPurple ( View v) {
        ImageButton personaPurple = findViewById(R.id.personaPurple);
        personaPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Learn_Kanji.class);
                startActivity(intent);
            }
        });
    }

    public void button_KANJI (View v){
        Button button_KANJI = findViewById(R.id.button_KANJI);
        Intent intent = new Intent(MainActivity.this, Kanji_HUB.class);
        startActivity(intent);
    }

    public void button_HIRAGANA (View v){
        Button button_HIRAGANA = findViewById(R.id.button_HIRAGANA);
        Intent intent = new Intent(MainActivity.this, Hiragana_HUB.class);
        startActivity(intent);
    }

    public void button_KATAKANA (View v){
        Button button_KATAKANA = findViewById(R.id.button_KATAKANA);
        Intent intent = new Intent(MainActivity.this, Katakana_HUB.class);
        startActivity(intent);
    }

    public void Admin_Button (View v){
        Button Admin_Button = findViewById(R.id.Admin_Button);
        Intent intent = new Intent(MainActivity.this, Admin_Hub.class);
        startActivity(intent);
    }

    public void buttonOnClick1 (View v) {
        Button Click = findViewById(R.id.button);
        TextView ChampText = findViewById(R.id.textView);
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

    public void buttonOnClick2 (View v) {
        Toast.makeText(MainActivity.this,"UEUE ",Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,"NAN NAN ",Toast.LENGTH_SHORT).show();
        TextView ChampText = findViewById(R.id.textView);
        ChampText.setText(editText.getText());
        ImageButton Damou_Button = findViewById(R.id.Damou_Button);
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

    public void buttonOnClickX (View v) {
            ImageButton personaPurple = findViewById(R.id.personaPurple);
            personaPurple.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    Intent intent = new Intent(MainActivity.this , ThirdActivity.class);
                    startActivity(intent);
                }
            });
    }
}