package com.example.mouad.kanjiapp;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_Katakana extends AppCompatActivity {
    DataBaseHelper myDb;
    Button button6_Delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__katakana);
        myDb = new DataBaseHelper(this);
        Button button_AJOUTER = findViewById(R.id.button_AJOUTER);
        EditText editText_CHARACTERE = findViewById(R.id.editText_CHARACTERE);
        EditText editText_NUMERO = findViewById(R.id.editText_NUMERO);
        EditText editText_SIGNIFICATION = findViewById(R.id.editText_SIGNIFICATION);
        Button button_EFFACER = findViewById(R.id.button_EFFACER);
        viewAll();
    }

    public void DeleteData(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Admin_Katakana.this);
        builder.setCancelable(true);
        builder.setTitle("Alerte");
        builder.setMessage("Supprimer toutes les données ?");
        builder.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                myDb.delete_KATAKANA();
                Toast.makeText(Admin_Katakana.this, "les données ont été supprimé", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("NON", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
        Button button_EFFACER = findViewById(R.id.button6_Delete);
    }

    public void buttonOnClick5(View v) {
        Button button_AJOUTER = findViewById(R.id.button_AJOUTER);
        EditText editText_CHARACTERE = findViewById(R.id.editText_CHARACTERE);
        EditText editText_NUMERO = findViewById(R.id.editText_NUMERO);
        EditText editText_SIGNIFICATION = findViewById(R.id.editText_SIGNIFICATION);
        if (editText_CHARACTERE.getText().toString().trim().length() == 0 || editText_NUMERO.getText().toString().trim().length() == 0 || editText_SIGNIFICATION.getText().toString().trim().length() == 0) {
            Toast.makeText(Admin_Katakana.this, "Veulliez remplir tout les champs", Toast.LENGTH_SHORT).show();
        } else {
            boolean isInserted = myDb.Insert_Katakana(editText_CHARACTERE.getText().toString(), editText_NUMERO.getText().toString(), editText_SIGNIFICATION.getText().toString());
            if (isInserted == true)
                Toast.makeText(Admin_Katakana.this, "Un nouveau Katakana a été crée ", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(Admin_Katakana.this, "Une erreure s'est produite", Toast.LENGTH_SHORT).show();
        }
    }

    public void displayAllData(String tittle, String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(tittle);
        builder.setMessage(content);
        builder.show();
    }

    public void viewAll() {
        Button button_VOIR = findViewById(R.id.button_VOIR);
        button_VOIR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = myDb.get_Katakana();
                if (result.getCount() == 0) {
                    displayAllData("Aucune donnée", "La base de données est vide");
                } else {
                    StringBuffer buffer = new StringBuffer();
                    while (result.moveToNext()) {
                        buffer.append("Charactere :" + result.getString(1) + "\n");
                        buffer.append("NUMERO :" + result.getString(2) + "\n");
                        buffer.append("SIGNIFICATION :" + result.getString(3) + "\n");
                    }
                    displayAllData("les Katakana crées", buffer.toString());
                }
            }
        });
    }
}

