package com.example.mouad.kanjiapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;

public class Katakana_Learn extends AppCompatActivity {
    private static ArrayList<Katakana> Katakana_ArrayList_Groupe_A = new ArrayList<Katakana>();
    private static ArrayList<Katakana> Katakana_ArrayList_Groupe_K = new ArrayList<Katakana>();
    private static ArrayList<Katakana> Katakana_ArrayList_Groupe_S = new ArrayList<Katakana>();
    private static ArrayList<Katakana> Katakana_ArrayList_Groupe_T = new ArrayList<Katakana>();
    private static ArrayList<Katakana> Katakana_ArrayList_Groupe_N = new ArrayList<Katakana>();
    private static ArrayList<Katakana> Katakana_ArrayList_Groupe_H = new ArrayList<Katakana>();
    private static ArrayList<Katakana> Katakana_ArrayList_Groupe_M = new ArrayList<Katakana>();
    private static ArrayList<Katakana> Katakana_ArrayList_Groupe_Y = new ArrayList<Katakana>();
    private static ArrayList<Katakana> Katakana_ArrayList_Groupe_R = new ArrayList<Katakana>();
    private static ArrayList<Katakana> Katakana_ArrayList_Groupe_W = new ArrayList<Katakana>();
    private static ArrayList<Katakana> Katakana_ArrayList_Groupe_0 = new ArrayList<Katakana>();
    private static RemoteAccess remoteAccess;
    Button buttonHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katakana__learn);
        buttonHome = findViewById(R.id.button_Home);
        remoteAccess = new RemoteAccess();
        remoteAccess.envoi("TousLesKatakana", new JSONArray());
        ListView listView = (ListView) findViewById(R.id.Historic_ListView);
        final String[] LesKatakanas = new String[]{"a", "Ka", "Sa", "Ta", "Na", "Ha", "Ma", "Ra", "Ya", "Wa", "N"};
        Katakana_ArrayList_Groupe_A = new ArrayList<Katakana>();
        Katakana_ArrayList_Groupe_K = new ArrayList<Katakana>();
        Katakana_ArrayList_Groupe_S = new ArrayList<Katakana>();
        Katakana_ArrayList_Groupe_T = new ArrayList<Katakana>();
        Katakana_ArrayList_Groupe_N = new ArrayList<Katakana>();
        Katakana_ArrayList_Groupe_H = new ArrayList<Katakana>();
        Katakana_ArrayList_Groupe_M = new ArrayList<Katakana>();
        Katakana_ArrayList_Groupe_Y = new ArrayList<Katakana>();
        Katakana_ArrayList_Groupe_R = new ArrayList<Katakana>();
        Katakana_ArrayList_Groupe_W = new ArrayList<Katakana>();
        Katakana_ArrayList_Groupe_0 = new ArrayList<Katakana>();
        final String niveauKatakana = LesKatakanas[0];
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, LesKatakanas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "toozoumouk", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Katakana_Learn.this, MainActivity.class);
                String niveauKatakana = LesKatakanas[0];
                switch (position) {
                    case 0:
                        position = 0;
                        if (Katakana_ArrayList_Groupe_A.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Katakana_Learn.this);
                            builder.setCancelable(true);
                            builder.setTitle("Alerte");
                            builder.setMessage("Le Niveau selectionné ne contient pas de Hiragana ");
                            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                            builder.show();
                            break;
                        } else {
                            niveauKatakana = LesKatakanas[0];
                            intent = new Intent(Katakana_Learn.this, Katakana_Lesson.class);
                            intent.putExtra("niveauKatakana", niveauKatakana);
                            intent.putExtra("LesKatakanas", Katakana_ArrayList_Groupe_A);
                            Katakana_Learn.this.startActivity(intent);
                            break;
                        }


                    case 1:
                        position = 1;
                        if (Katakana_ArrayList_Groupe_K.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Katakana_Learn.this);
                            builder.setCancelable(true);
                            builder.setTitle("Alerte");
                            builder.setMessage("Le Niveau selectionné ne contient pas de Hiragana ");
                            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                            builder.show();
                            break;
                        } else {
                            niveauKatakana = LesKatakanas[1];
                            intent = new Intent(Katakana_Learn.this, Katakana_Lesson.class);
                            intent.putExtra("niveauKatakana", niveauKatakana);
                            intent.putExtra("LesKatakanas", Katakana_ArrayList_Groupe_K);
                            Katakana_Learn.this.startActivity(intent);
                            break;
                        }
                }
            }
        });
    }


    public static ArrayList<Katakana> getKatakana_ArrayList_Groupe_A() {
        return Katakana_ArrayList_Groupe_A;
    }

    public static void setKatakana_ArrayList_Groupe_A(ArrayList<Katakana> katakana_ArrayList_Groupe_A) {
        Katakana_ArrayList_Groupe_A = katakana_ArrayList_Groupe_A;
    }

    public static ArrayList<Katakana> getKatakana_ArrayList_Groupe_K() {
        return Katakana_ArrayList_Groupe_K;
    }

    public static void setKatakana_ArrayList_Groupe_K(ArrayList<Katakana> katakana_ArrayList_Groupe_K) {
        Katakana_ArrayList_Groupe_K = katakana_ArrayList_Groupe_K;
    }

    public static ArrayList<Katakana> getKatakana_ArrayList_Groupe_S() {
        return Katakana_ArrayList_Groupe_S;
    }

    public static void setKatakana_ArrayList_Groupe_S(ArrayList<Katakana> katakana_ArrayList_Groupe_S) {
        Katakana_ArrayList_Groupe_S = katakana_ArrayList_Groupe_S;
    }

    public static ArrayList<Katakana> getKatakana_ArrayList_Groupe_T() {
        return Katakana_ArrayList_Groupe_T;
    }

    public static void setKatakana_ArrayList_Groupe_T(ArrayList<Katakana> katakana_ArrayList_Groupe_T) {
        Katakana_ArrayList_Groupe_T = katakana_ArrayList_Groupe_T;
    }

    public static ArrayList<Katakana> getKatakana_ArrayList_Groupe_N() {
        return Katakana_ArrayList_Groupe_N;
    }

    public static void setKatakana_ArrayList_Groupe_N(ArrayList<Katakana> katakana_ArrayList_Groupe_N) {
        Katakana_ArrayList_Groupe_N = katakana_ArrayList_Groupe_N;
    }

    public static ArrayList<Katakana> getKatakana_ArrayList_Groupe_H() {
        return Katakana_ArrayList_Groupe_H;
    }

    public static void setKatakana_ArrayList_Groupe_H(ArrayList<Katakana> katakana_ArrayList_Groupe_H) {
        Katakana_ArrayList_Groupe_H = katakana_ArrayList_Groupe_H;
    }

    public static ArrayList<Katakana> getKatakana_ArrayList_Groupe_M() {
        return Katakana_ArrayList_Groupe_M;
    }

    public static void setKatakana_ArrayList_Groupe_M(ArrayList<Katakana> katakana_ArrayList_Groupe_M) {
        Katakana_ArrayList_Groupe_M = katakana_ArrayList_Groupe_M;
    }

    public static ArrayList<Katakana> getKatakana_ArrayList_Groupe_Y() {
        return Katakana_ArrayList_Groupe_Y;
    }

    public static void setKatakana_ArrayList_Groupe_Y(ArrayList<Katakana> katakana_ArrayList_Groupe_Y) {
        Katakana_ArrayList_Groupe_Y = katakana_ArrayList_Groupe_Y;
    }

    public static ArrayList<Katakana> getKatakana_ArrayList_Groupe_R() {
        return Katakana_ArrayList_Groupe_R;
    }

    public static void setKatakana_ArrayList_Groupe_R(ArrayList<Katakana> katakana_ArrayList_Groupe_R) {
        Katakana_ArrayList_Groupe_R = katakana_ArrayList_Groupe_R;
    }

    public static ArrayList<Katakana> getKatakana_ArrayList_Groupe_W() {
        return Katakana_ArrayList_Groupe_W;
    }

    public static void setKatakana_ArrayList_Groupe_W(ArrayList<Katakana> katakana_ArrayList_Groupe_W) {
        Katakana_ArrayList_Groupe_W = katakana_ArrayList_Groupe_W;
    }

    public static ArrayList<Katakana> getKatakana_ArrayList_Groupe_0() {
        return Katakana_ArrayList_Groupe_0;
    }

    public static void setKatakana_ArrayList_Groupe_0(ArrayList<Katakana> katakana_ArrayList_Groupe_0) {
        Katakana_ArrayList_Groupe_0 = katakana_ArrayList_Groupe_0;
    }
}
