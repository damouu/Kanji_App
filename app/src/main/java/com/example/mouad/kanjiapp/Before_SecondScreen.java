package com.example.mouad.kanjiapp;

import android.content.DialogInterface;
import android.content.Intent;
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

public class Before_SecondScreen extends AppCompatActivity {
    User user;
    private static RemoteAccess remoteAccess;
    private static ArrayList<Kanji> Kanji_JLPT5_ArrayList;
    private static ArrayList<Kanji> Kanji_JLPT4_ArrayList;
    private static ArrayList<Kanji> Kanji_JLPT3_ArrayList;
    private static ArrayList<Kanji> Kanji_JLPT2_ArrayList;
    private static ArrayList<Kanji> Kanji_JLPT1_ArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before__second_screen);
        remoteAccess = new RemoteAccess();
        remoteAccess.envoi("TousLesKanjis", new JSONArray());
        Button buttonHome = findViewById(R.id.button_Home);
        ListView listView = (ListView) findViewById(R.id.Historic_ListView);
        Kanji_JLPT5_ArrayList = new ArrayList<Kanji>();
        Kanji_JLPT4_ArrayList = new ArrayList<Kanji>();
        Kanji_JLPT3_ArrayList = new ArrayList<Kanji>();
        Kanji_JLPT2_ArrayList = new ArrayList<Kanji>();
        Kanji_JLPT1_ArrayList = new ArrayList<Kanji>();
        final String[] leskanjis = new String[]{"JLPT5", "JLPT4", "JLPT3", "JLPT2", "JLPT1"};
        final String niveauJLPT = leskanjis[0];
        user = (User) getIntent().getSerializableExtra("user");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, leskanjis);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "chargement", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                String niveauJLPT = leskanjis[0];
                switch (position) {
                    case 0:
                        position = 0;
                        if (Kanji_JLPT5_ArrayList.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Before_SecondScreen.this);
                            builder.setCancelable(true);
                            builder.setTitle("Alerte");
                            builder.setMessage("Le Niveau selectionné ne contient pas de Kanji ");
                            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                            builder.show();
                            break;
                        } else {
                            niveauJLPT = leskanjis[0];
                            intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                            intent.putExtra("niveauJLPT", niveauJLPT);
                            intent.putExtra("Leskanjis", Kanji_JLPT5_ArrayList);
                            intent.putExtra("user", user);
                            Before_SecondScreen.this.startActivity(intent);
                            break;
                        }

                    case 1:
                        position = 1;
                        if (Kanji_JLPT4_ArrayList.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Before_SecondScreen.this);
                            builder.setCancelable(true);
                            builder.setTitle("Alerte");
                            builder.setMessage("Le Niveau selectionné ne contient pas de Kanji ");
                            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                            builder.show();
                            break;
                        } else {
                            niveauJLPT = leskanjis[1];
                            intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                            intent.putExtra("niveauJLPT", niveauJLPT);
                            intent.putExtra("Leskanjis", Kanji_JLPT4_ArrayList);
                            intent.putExtra("user", user);
                            Before_SecondScreen.this.startActivity(intent);
                            break;
                        }
                    case 2:
                        position = 2;
                        if (Kanji_JLPT3_ArrayList.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Before_SecondScreen.this);
                            builder.setCancelable(true);
                            builder.setTitle("Alerte");
                            builder.setMessage("Le Niveau selectionné ne contient pas de Kanji ");
                            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                            builder.show();
                            break;
                        } else {
                            niveauJLPT = leskanjis[2];
                            intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                            intent.putExtra("niveauJLPT", niveauJLPT);
                            intent.putExtra("Leskanjis", Kanji_JLPT3_ArrayList);
                            intent.putExtra("user", user);
                            Before_SecondScreen.this.startActivity(intent);
                            break;
                        }
                    case 3:
                        position = 3;
                        if (Kanji_JLPT2_ArrayList.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Before_SecondScreen.this);
                            builder.setCancelable(true);
                            builder.setTitle("Alerte");
                            builder.setMessage("Le Niveau selectionné ne contient pas de Kanji ");
                            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                            builder.show();
                            break;
                        } else {
                            niveauJLPT = leskanjis[3];
                            intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                            intent.putExtra("niveauJLPT", niveauJLPT);
                            intent.putExtra("Leskanjis", Kanji_JLPT2_ArrayList);
                            intent.putExtra("user", user);
                            Before_SecondScreen.this.startActivity(intent);
                            break;
                        }

                    case 4:
                        position = 4;
                        if (Kanji_JLPT1_ArrayList.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Before_SecondScreen.this);
                            builder.setCancelable(true);
                            builder.setTitle("Alerte");
                            builder.setMessage("Le Niveau selectionné ne contient pas de Kanji ");
                            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                            builder.show();
                            break;
                        } else {
                            niveauJLPT = leskanjis[4];
                            intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                            intent.putExtra("niveauJLPT", niveauJLPT);
                            intent.putExtra("Leskanjis", Kanji_JLPT1_ArrayList);
                            intent.putExtra("user", user);
                            Before_SecondScreen.this.startActivity(intent);
                            break;
                        }
                    case 5:
                        position = 5;
                        niveauJLPT = leskanjis[5];
                        intent = new Intent(Before_SecondScreen.this, SecondScreen.class);
                        intent.putExtra("niveauJLPT", niveauJLPT);
                        Before_SecondScreen.this.startActivity(intent);
                        break;
                }

            }

        });
    }

    public void button_Home(View v) {
        Button button_Home = findViewById(R.id.button_Home);
        button_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Before_SecondScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    public static ArrayList<Kanji> getKanji_JLPT5_ArrayList() {
        return Kanji_JLPT5_ArrayList;
    }

    public static void setKanji_JLPT5_ArrayList(ArrayList<Kanji> kanji_JLPT5_ArrayList) {
        Kanji_JLPT5_ArrayList = kanji_JLPT5_ArrayList;
    }

    public static ArrayList<Kanji> getKanji_JLPT4_ArrayList() {
        return Kanji_JLPT4_ArrayList;
    }

    public static void setKanji_JLPT4_ArrayList(ArrayList<Kanji> kanji_JLPT4_ArrayList) {
        Kanji_JLPT4_ArrayList = kanji_JLPT4_ArrayList;
    }

    public static ArrayList<Kanji> getKanji_JLPT3_ArrayList() {
        return Kanji_JLPT3_ArrayList;
    }

    public static void setKanji_JLPT3_ArrayList(ArrayList<Kanji> kanji_JLPT3_ArrayList) {
        Kanji_JLPT3_ArrayList = kanji_JLPT3_ArrayList;
    }

    public static ArrayList<Kanji> getKanji_JLPT2_ArrayList() {
        return Kanji_JLPT2_ArrayList;
    }

    public static void setKanji_JLPT2_ArrayList(ArrayList<Kanji> kanji_JLPT2_ArrayList) {
        Kanji_JLPT2_ArrayList = kanji_JLPT2_ArrayList;
    }

    public static ArrayList<Kanji> getKanji_JLPT1_ArrayList() {
        return Kanji_JLPT1_ArrayList;
    }

    public static void setKanji_JLPT1_ArrayList(ArrayList<Kanji> kanji_JLPT1_ArrayList) {
        Kanji_JLPT1_ArrayList = kanji_JLPT1_ArrayList;
    }


}