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
        TextView Time_TextView = findViewById(R.id.Time_TextView);
        viewAll();
    }

    public void DeleteData(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(Admin.this);
        builder.setCancelable(true);
        builder.setTitle("Warning");
        builder.setMessage("Delete all the data ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            myDb.deleteData();
            Toast.makeText(Admin.this,"the data has been deleted ",Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
        Button button6_Delete_ = findViewById(R.id.button6_Delete);
    }

    public void buttonOnClick5(View v){
        Button button5 = findViewById(R.id.button5);
        EditText editText  = findViewById(R.id.editText);
        EditText editText4 = findViewById(R.id.editText4);
        EditText editText5 = findViewById(R.id.editText5);
        EditText editText6 = findViewById(R.id.editText6);
        EditText editText7 = findViewById(R.id.editText7);
        if(editText.getText().toString().trim().length() == 0 || editText4.getText().toString().trim().length() == 0 ||editText5.getText().toString().trim().length()== 0 ||editText6.getText().toString().trim().length()==0 || editText7.getText().toString().trim().length()==0){
            Toast.makeText(Admin.this,"pLease fill all the fields",Toast.LENGTH_SHORT).show();
        }
    else {
            boolean isInserted = myDb.InsertData(editText.getText().toString(), editText4.getText().toString(), editText5.getText().toString(), editText6.getText().toString(), editText7.getText().toString());
            if (isInserted == true) {
                Toast.makeText(Admin.this, "The Kanji" + " " + editText.getText().toString() + " " + "has been added to the database", Toast.LENGTH_SHORT).show();
                editText.setText("Charactere");
                editText4.setText("NUMERO");
                editText5.setText("SIGNIFICATION");
                editText6.setText("LECTURE_KUN");
                editText7.setText("LECTURE_ON");
            } else {
                Toast.makeText(Admin.this, "Une erreure s'est produite", Toast.LENGTH_SHORT).show();
            }
        }
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
                     displayAllData("no data", "The database is empty");
              } else {
                     StringBuffer buffer = new StringBuffer();
               while(result.moveToNext()) {
                 buffer.append("Charactere :" + result.getString(1) + "\n");
                 buffer.append("NUMERO :" + result.getString(2) + "\n");
                 buffer.append("SIGNIFICATION :" + result.getString(3) + "\n");
                 buffer.append("LECTURE_KUN :" + result.getString(4) + "\n");
                 buffer.append("LECTURE_ON :" + result.getString(5) + "\n");
                    }
                 displayAllData("les kanjis crées", buffer.toString());
                    } }
                });
                }
            }