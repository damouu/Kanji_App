package com.example.mouad.kanjiapp;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Admin extends AppCompatActivity {
    DataBaseHelper myDb;
    Button button6_Delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        myDb = new DataBaseHelper(this);
        EditText editText  = findViewById(R.id.editText);
        EditText editText4 = findViewById(R.id.editText4);
        EditText editText5 = findViewById(R.id.editText5);
        EditText editText6 = findViewById(R.id.editText6);
        EditText editText7 = findViewById(R.id.editText7);
        Button button3 = findViewById(R.id.button3);
        Button button6_Delete_ = findViewById(R.id.button6_Delete);
        viewAll();
    }

    public void DeleteData(View v){
            Button button6_Delete_ = findViewById(R.id.button6_Delete);
            myDb.deleteData();
            Toast.makeText(Admin.this,"data has been deleted",Toast.LENGTH_SHORT).show();
    }

    public void buttonOnClick5(View v){
        Button button5 = findViewById(R.id.button5);
        EditText editText  = findViewById(R.id.editText);
        EditText editText4 = findViewById(R.id.editText4);
        EditText editText5 = findViewById(R.id.editText5);
        EditText editText6 = findViewById(R.id.editText6);
        EditText editText7 = findViewById(R.id.editText7);
        boolean isInserted =  myDb.InsertData(editText.getText().toString(), editText4.getText().toString(),editText5.getText().toString(),editText6.getText().toString(),editText7.getText().toString());
        if (isInserted ==true)
            Toast.makeText(Admin.this,"UEUE ",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(Admin.this,"NAN NAN ",Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(Admin.this);
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

    public void displayAllData(String tittle, String content){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(tittle);
        builder.setMessage(content);
        builder.show();
    }

            public void viewAll() {
                Button button3 = findViewById(R.id.button3);
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor result = myDb.getAllData();
                        if (result.getCount() == 0) {
                            displayAllData("No Data", "the database is empty");
                        } else {
                            StringBuffer buffer = new StringBuffer();
                            while (result.moveToNext()) {
                                buffer.append("Charactere :" + result.getString(1) + "\n");
                                buffer.append("NUMERO :" + result.getString(2) + "\n");
                                buffer.append("SIGNIFICATION :" + result.getString(3) + "\n");
                                buffer.append("LECTURE_KUN :" + result.getString(4) + "\n");
                                buffer.append("LECTURE_ON :" + result.getString(5) + "\n");
                            }
                            displayAllData("les kanjis crées", buffer.toString());
                        }
                    }
                });
            }
        }
