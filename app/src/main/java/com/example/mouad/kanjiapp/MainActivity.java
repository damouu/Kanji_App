package com.example.mouad.kanjiapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.nfc.Tag;
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
    DataBaseHelper myDb;
    TextView ChampText;
    EditText editText;
    Button ViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState)                                                  // this lines are for associate the class with the XML file .
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DataBaseHelper(this);
        Button ViewAll = findViewById(R.id.ViewAll);
        viewAll();
                                                                                                                             // here we say that MainActivity's  XML layout is activity_main.
    }

    public void buttonOnClick3 (View v)                                                                 // we create  a method name buttonOnClick3 associated to the right button .
    {
        ImageButton personaButton = findViewById(R.id.imageButton2);                                   // this two lines instantiated an ImageButton named personaButton and associated the button to the xml imageButton2.
        personaButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this , SecondScreen.class);      // here we are instantiated a new intent to go the SecondScreen.
                startActivity(intent);                                                                 // and now we are staring the intent by an startActivity (in android a page == Activity).
            }
        });
    }

    public void personaPurple ( View v)
    {
        ImageButton personaPurple = findViewById(R.id.personaPurple);
        personaPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Learn_Kanji.class);      // here we are instantiated a new intent to go the SecondScreen.
                startActivity(intent);
            }
        });
    }


    public void buttonOnClick1 (View v)
    {
        Button Click = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editText2);
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

    public void buttonOnClick2 (View v)
    {
        EditText editText = findViewById(R.id.editText2);
       boolean isInserted =  myDb.InsertData(editText.getText().toString());
       if (isInserted ==true)
           Toast.makeText(MainActivity.this,"UEUE ",Toast.LENGTH_SHORT).show();
       else
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

    public void buttonOnClickX (View v)
    {
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

    public void displayAllData(String tittle, String content){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(tittle);
        builder.setMessage(content);
        builder.show();
    }
    public void viewAll(){
        Button ViewAll= (Button) findViewById(R.id.ViewAll);
        ViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = myDb.getAllData();
                if (result.getCount() ==0){
                    displayAllData("error","error");
                }
                else {
                    StringBuffer buffer = new StringBuffer();
                    while (result.moveToNext()){
                        buffer.append("Charactere :" +result.getString(1));
                    }
                    displayAllData("Charactere list",buffer.toString());
                }
            }
        });
    }

}

