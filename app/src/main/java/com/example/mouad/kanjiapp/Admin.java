package com.example.mouad.kanjiapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;

public class Admin extends AppCompatActivity implements Serializable {
    private static RemoteAccess remoteAccess;
    public static ArrayList<Kanji> LesKanjis;
    DataBaseHelper myDb;
    EditText editText;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    EditText editText7;
    Button button6_Delete;
    Button button3;
    TextView Time_TextView;
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        myDb = new DataBaseHelper(this);
        remoteAccess = new RemoteAccess();
        editText = findViewById(R.id.editText);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        editText6 = findViewById(R.id.editText6);
        editText7 = findViewById(R.id.editText7);
        button3 = findViewById(R.id.button3);
        button6_Delete = findViewById(R.id.button6_Delete);
        Time_TextView = findViewById(R.id.Time_TextView);
        button5 = findViewById(R.id.button5);
        remoteAccess.envoi("TousLesKanjis", new JSONArray());
    }

    public static void setLesKanjis(ArrayList<Kanji> lesKanjis) {
        LesKanjis = lesKanjis;
    }

    public ArrayList<Kanji> getLesKanjis() {
        return LesKanjis;
    }

    public void DeleteData(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Admin.this);
        builder.setCancelable(true);
        builder.setTitle("Warning");
        builder.setMessage("Delete all the data ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                myDb.deleteData();
                Toast.makeText(Admin.this, "the data has been deleted ", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void buttonOnClick5(View v) {
        Kanji kanji = new Kanji("\"" + editText.getText().toString() + "\"", Integer.parseInt(editText4.getText().toString()), "\"" + editText5.getText().toString() + "\"", "\"" + editText6.getText().toString() + "\"", "\"" + editText7.getText().toString() + "\"");
        if (editText.getText().toString().trim().length() == 0 || editText4.getText().toString().trim().length() == 0 || editText5.getText().toString().trim().length() == 0 || editText6.getText().toString().trim().length() == 0 || editText7.getText().toString().trim().length() == 0) {
            Toast.makeText(Admin.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        } else {
            remoteAccess.envoi("enreg",kanji.convertToJSONArray());
            Toast.makeText(Admin.this, "The Kanji" + " " + kanji.getCharactere() + " " + "has been added to the database", Toast.LENGTH_SHORT).show();
            editText.setText("Charactere");
            editText4.setText("NUMERO");
            editText5.setText("SIGNIFICATION");
            editText6.setText("LECTURE_KUN");
            editText7.setText("LECTURE_ON");
            LesKanjis.size();
        }
    }
//sdsds
    public void displayAllData(String tittle, String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(tittle);
        builder.setMessage(content);
        builder.show();
    }

    public void viewAll(View v) {
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LesKanjis.size() == 0) {
                    displayAllData("no data", "The database is empty");
                } else {
                    StringBuffer buffer = new StringBuffer();
                    for (Kanji Kanji:LesKanjis) {
                        buffer.append("Charactere :"    + Kanji.getCharactere()     + "\n");
                        buffer.append("NUMERO :"        + Kanji.getNumero()         + "\n");
                        buffer.append("SIGNIFICATION :" + Kanji.getSignification()  + "\n");
                        buffer.append("LECTURE_KUN :"   + Kanji.getLecture_kenyon() + "\n");
                        buffer.append("LECTURE_ON :"    + Kanji.getLecture_onyomi() + "\n");
                    }
                    displayAllData("les kanjis crées", buffer.toString());
                }
            }
        });
    }

//dsqds
    public static ArrayList<Kanji> getLesKanjis(ArrayList<Kanji> lesKanjisJSON) {
        return LesKanjis;
    }

}