package com.example.mouad.kanjiapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mouad on 27/12/2017.
 */

public class ThirdActivity extends AppCompatActivity
{
        private ListView list;


        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.thirdactivity);
            list = findViewById(R.id.ListView);

            List<Kanji> leskanjis = new ArrayList<Kanji>();
            Kanji hana = new Kanji("花",1,"hana","hana","fleur");
            Kanji tabe = new Kanji("食",2,"tabe","taberu","manger");
            Kanji yomi = new Kanji("読",3,"yomi","yomi","Lire");
            leskanjis.add(hana);
            leskanjis.add(tabe);
            leskanjis.add(yomi);


            final ArrayAdapter<Kanji> arrayAdapter = new ArrayAdapter<Kanji>(this,android.R.layout.simple_list_item_1,leskanjis);
            list.setAdapter(arrayAdapter);

        }

        public void buttonOnClickX (View v)
        {

        }

        public void buttonTest (View v)
        {
            EditText edit = findViewById(R.id.whatsyourname);
            TextView text = findViewById(R.id.textviewmountain);
            Button button = findViewById(R.id.buttontest);
            EditText edit2 = findViewById(R.id.editText4);
            TextView text2 = findViewById(R.id.textView3);
            if (edit.getText().toString().trim().length()<=0 || edit2.getText().toString().trim().length() <=0)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(ThirdActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Alerte");
                builder.setMessage("some fields are empty , please fill all the fields ");
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

            Test_Class t = new Test_Class();
            t.setName(edit.getText().toString());
            edit.setText(t.getName());
            int i = Integer.parseInt(edit2.getText().toString());
            t.setAge(i);
            int Age = t.getAge();
            String ageR = String.valueOf(Age);
            text.setText(t.getName().toString());
            text2.setText(ageR);


        }

}



