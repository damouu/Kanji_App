package com.example.mouad.kanjiapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
/**
 * Created by mouad on 27/12/2017.
 */

public class ThirdActivity extends AppCompatActivity
{

        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.thirdactivity);

        }

        public void buttonOnClickX (View v)
        {

        }

        public void buttonTest (View v)
        {
            EditText edit = (EditText) findViewById(R.id.whatsyourname);
            TextView text = (TextView) findViewById(R.id.textviewmountain);
            Button button = (Button) findViewById(R.id.buttontest);
            EditText edit2 = (EditText) findViewById(R.id.editText4);
            TextView text2 = (TextView) findViewById(R.id.textView3);
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



