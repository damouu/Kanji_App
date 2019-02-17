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

public class Hiragana_beforeT extends AppCompatActivity {
    private static RemoteAccess remoteAccess;
    private static ArrayList<Hiragana> Hiragana_ArrayList_Groupe_A;
    private static ArrayList<Hiragana> Hiragana_ArrayList_Groupe_K;
    private static ArrayList<Hiragana> Hiragana_ArrayList_Groupe_S;
    private static ArrayList<Hiragana> Hiragana_ArrayList_Groupe_T;
    private static ArrayList<Hiragana> Hiragana_ArrayList_Groupe_N;
    private static ArrayList<Hiragana> Hiragana_ArrayList_Groupe_H;
    private static ArrayList<Hiragana> Hiragana_ArrayList_Groupe_M;
    private static ArrayList<Hiragana> Hiragana_ArrayList_Groupe_Y;
    private static ArrayList<Hiragana> Hiragana_ArrayList_Groupe_R;
    private static ArrayList<Hiragana> Hiragana_ArrayList_Groupe_W;
    private static ArrayList<Hiragana> Hiragana_ArrayList_Groupe_0;
    Button buttonHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana_before_t);
        buttonHome = findViewById(R.id.button_Home);
        remoteAccess = new RemoteAccess();
        remoteAccess.envoi("TousLesHiragana", new JSONArray());
        ListView listView = (ListView) findViewById(R.id.Historic_ListView);
        final String[] LesHiraganas = new String[]{"a", "Ka", "Sa", "Ta", "Na", "Ha", "Ma", "Ra", "Ya", "Wa", "N"};
        Hiragana_ArrayList_Groupe_A = new ArrayList<Hiragana>();
        Hiragana_ArrayList_Groupe_K = new ArrayList<Hiragana>();
        Hiragana_ArrayList_Groupe_S = new ArrayList<Hiragana>();
        Hiragana_ArrayList_Groupe_T = new ArrayList<Hiragana>();
        Hiragana_ArrayList_Groupe_N = new ArrayList<Hiragana>();
        Hiragana_ArrayList_Groupe_H = new ArrayList<Hiragana>();
        Hiragana_ArrayList_Groupe_M = new ArrayList<Hiragana>();
        Hiragana_ArrayList_Groupe_Y = new ArrayList<Hiragana>();
        Hiragana_ArrayList_Groupe_R = new ArrayList<Hiragana>();
        Hiragana_ArrayList_Groupe_W = new ArrayList<Hiragana>();
        Hiragana_ArrayList_Groupe_0 = new ArrayList<Hiragana>();
        final String niveauHiragana = LesHiraganas[0];
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, LesHiraganas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Hiragana_beforeT.this, MainActivity.class);
                String niveauHiragana = LesHiraganas[0];
                switch (position) {
                    case 0:
                        position = 0;
                        if (Hiragana_ArrayList_Groupe_A.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Hiragana_beforeT.this);
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
                            niveauHiragana = LesHiraganas[0];
                            intent = new Intent(Hiragana_beforeT.this, Hiragana_Test.class);
                            intent.putExtra("niveauHiragana", niveauHiragana);
                            intent.putExtra("LesHiraganas", Hiragana_ArrayList_Groupe_A);
                            Hiragana_beforeT.this.startActivity(intent);
                            break;
                        }
                    case 1:
                        position = 1;
                        if (Hiragana_ArrayList_Groupe_K.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Hiragana_beforeT.this);
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
                            niveauHiragana = LesHiraganas[1];
                            intent = new Intent(Hiragana_beforeT.this, Hiragana_Test.class);
                            intent.putExtra("niveauHiragana", niveauHiragana);
                            intent.putExtra("LesHiraganas", Hiragana_ArrayList_Groupe_K);
                            Hiragana_beforeT.this.startActivity(intent);
                            break;
                        }
                    case 2:
                        position = 2;
                        if (Hiragana_ArrayList_Groupe_S.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Hiragana_beforeT.this);
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
                            niveauHiragana = LesHiraganas[2];
                            intent = new Intent(Hiragana_beforeT.this, Hiragana_Test.class);
                            intent.putExtra("niveauHiragana", niveauHiragana);
                            intent.putExtra("LesHiraganas", Hiragana_ArrayList_Groupe_S);
                            Hiragana_beforeT.this.startActivity(intent);
                            break;
                        }
                    case 3:
                        position = 3;
                        if (Hiragana_ArrayList_Groupe_T.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Hiragana_beforeT.this);
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
                            niveauHiragana = LesHiraganas[3];
                            intent = new Intent(Hiragana_beforeT.this, Hiragana_Test.class);
                            intent.putExtra("niveauHiragana", niveauHiragana);
                            intent.putExtra("LesHiraganas", Hiragana_ArrayList_Groupe_T);
                            Hiragana_beforeT.this.startActivity(intent);
                            break;
                        }
                    case 4:
                        position = 4;
                        if (Hiragana_ArrayList_Groupe_N.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Hiragana_beforeT.this);
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
                            niveauHiragana = LesHiraganas[4];
                            intent = new Intent(Hiragana_beforeT.this, Hiragana_Test.class);
                            intent.putExtra("niveauHiragana", niveauHiragana);
                            intent.putExtra("LesHiraganas", Hiragana_ArrayList_Groupe_N);
                            Hiragana_beforeT.this.startActivity(intent);
                            break;
                        }
                    case 5:
                        position = 5;
                        if (Hiragana_ArrayList_Groupe_H.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Hiragana_beforeT.this);
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
                            niveauHiragana = LesHiraganas[5];
                            intent = new Intent(Hiragana_beforeT.this, Hiragana_Test.class);
                            intent.putExtra("niveauHiragana", niveauHiragana);
                            intent.putExtra("LesHiraganas", Hiragana_ArrayList_Groupe_H);
                            Hiragana_beforeT.this.startActivity(intent);
                            break;
                        }
                    case 6:
                        position = 6;
                        if (Hiragana_ArrayList_Groupe_M.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Hiragana_beforeT.this);
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
                            niveauHiragana = LesHiraganas[6];
                            intent = new Intent(Hiragana_beforeT.this, Hiragana_Test.class);
                            intent.putExtra("niveauHiragana", niveauHiragana);
                            intent.putExtra("LesHiraganas", Hiragana_ArrayList_Groupe_M);
                            Hiragana_beforeT.this.startActivity(intent);
                            break;
                        }
                    case 7:
                        position = 7;
                        if (Hiragana_ArrayList_Groupe_R.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Hiragana_beforeT.this);
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
                            niveauHiragana = LesHiraganas[7];
                            intent = new Intent(Hiragana_beforeT.this, Hiragana_Test.class);
                            intent.putExtra("niveauHiragana", niveauHiragana);
                            intent.putExtra("LesHiraganas", Hiragana_ArrayList_Groupe_R);
                            Hiragana_beforeT.this.startActivity(intent);
                            break;
                        }
                    case 8:
                        position = 8;
                        if (Hiragana_ArrayList_Groupe_Y.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Hiragana_beforeT.this);
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
                            niveauHiragana = LesHiraganas[8];
                            intent = new Intent(Hiragana_beforeT.this, Hiragana_Test.class);
                            intent.putExtra("niveauHiragana", niveauHiragana);
                            intent.putExtra("LesHiraganas", Hiragana_ArrayList_Groupe_Y);
                            Hiragana_beforeT.this.startActivity(intent);
                            break;
                        }
                    case 9:
                        position = 9;
                        if (Hiragana_ArrayList_Groupe_W.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Hiragana_beforeT.this);
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
                            niveauHiragana = LesHiraganas[9];
                            intent = new Intent(Hiragana_beforeT.this, Hiragana_Test.class);
                            intent.putExtra("niveauHiragana", niveauHiragana);
                            intent.putExtra("LesHiraganas", Hiragana_ArrayList_Groupe_W);
                            Hiragana_beforeT.this.startActivity(intent);
                            break;
                        }
                    case 10:
                        position = 10;
                        if (Hiragana_ArrayList_Groupe_0.isEmpty()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Hiragana_beforeT.this);
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
                            niveauHiragana = LesHiraganas[9];
                            intent = new Intent(Hiragana_beforeT.this, Hiragana_Test.class);
                            intent.putExtra("niveauHiragana", niveauHiragana);
                            intent.putExtra("LesHiraganas", Hiragana_ArrayList_Groupe_0);
                            Hiragana_beforeT.this.startActivity(intent);
                            break;
                        }
                }
            }
        });
    }

    public void button_Home(View v) {
        Button button_Home = findViewById(R.id.button_Home);
        button_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hiragana_beforeT.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public static ArrayList<Hiragana> getHiragana_ArrayList_Groupe_A() {
        return Hiragana_ArrayList_Groupe_A;
    }

    public static void setHiragana_ArrayList_Groupe_A(ArrayList<Hiragana> hiragana_ArrayList_Groupe_A) {
        Hiragana_ArrayList_Groupe_A = hiragana_ArrayList_Groupe_A;
    }

    public static ArrayList<Hiragana> getHiragana_ArrayList_Groupe_K() {
        return Hiragana_ArrayList_Groupe_K;
    }

    public static void setHiragana_ArrayList_Groupe_K(ArrayList<Hiragana> hiragana_ArrayList_Groupe_K) {
        Hiragana_ArrayList_Groupe_K = hiragana_ArrayList_Groupe_K;
    }

    public static ArrayList<Hiragana> getHiragana_ArrayList_Groupe_S() {
        return Hiragana_ArrayList_Groupe_S;
    }

    public static void setHiragana_ArrayList_Groupe_S(ArrayList<Hiragana> hiragana_ArrayList_Groupe_S) {
        Hiragana_ArrayList_Groupe_S = hiragana_ArrayList_Groupe_S;
    }

    public static ArrayList<Hiragana> getHiragana_ArrayList_Groupe_T() {
        return Hiragana_ArrayList_Groupe_T;
    }

    public static void setHiragana_ArrayList_Groupe_T(ArrayList<Hiragana> hiragana_ArrayList_Groupe_T) {
        Hiragana_ArrayList_Groupe_T = hiragana_ArrayList_Groupe_T;
    }

    public static ArrayList<Hiragana> getHiragana_ArrayList_Groupe_N() {
        return Hiragana_ArrayList_Groupe_N;
    }

    public static void setHiragana_ArrayList_Groupe_N(ArrayList<Hiragana> hiragana_ArrayList_Groupe_N) {
        Hiragana_ArrayList_Groupe_N = hiragana_ArrayList_Groupe_N;
    }

    public static ArrayList<Hiragana> getHiragana_ArrayList_Groupe_H() {
        return Hiragana_ArrayList_Groupe_H;
    }

    public static void setHiragana_ArrayList_Groupe_H(ArrayList<Hiragana> hiragana_ArrayList_Groupe_H) {
        Hiragana_ArrayList_Groupe_H = hiragana_ArrayList_Groupe_H;
    }

    public static ArrayList<Hiragana> getHiragana_ArrayList_Groupe_M() {
        return Hiragana_ArrayList_Groupe_M;
    }

    public static void setHiragana_ArrayList_Groupe_M(ArrayList<Hiragana> hiragana_ArrayList_Groupe_M) {
        Hiragana_ArrayList_Groupe_M = hiragana_ArrayList_Groupe_M;
    }

    public static ArrayList<Hiragana> getHiragana_ArrayList_Groupe_Y() {
        return Hiragana_ArrayList_Groupe_Y;
    }

    public static void setHiragana_ArrayList_Groupe_Y(ArrayList<Hiragana> hiragana_ArrayList_Groupe_Y) {
        Hiragana_ArrayList_Groupe_Y = hiragana_ArrayList_Groupe_Y;
    }

    public static ArrayList<Hiragana> getHiragana_ArrayList_Groupe_R() {
        return Hiragana_ArrayList_Groupe_R;
    }

    public static void setHiragana_ArrayList_Groupe_R(ArrayList<Hiragana> hiragana_ArrayList_Groupe_R) {
        Hiragana_ArrayList_Groupe_R = hiragana_ArrayList_Groupe_R;
    }

    public static ArrayList<Hiragana> getHiragana_ArrayList_Groupe_W() {
        return Hiragana_ArrayList_Groupe_W;
    }

    public static void setHiragana_ArrayList_Groupe_W(ArrayList<Hiragana> hiragana_ArrayList_Groupe_W) {
        Hiragana_ArrayList_Groupe_W = hiragana_ArrayList_Groupe_W;
    }

    public static ArrayList<Hiragana> getHiragana_ArrayList_Groupe_0() {
        return Hiragana_ArrayList_Groupe_0;
    }

    public static void setHiragana_ArrayList_Groupe_0(ArrayList<Hiragana> hiragana_ArrayList_Groupe_0) {
        Hiragana_ArrayList_Groupe_0 = hiragana_ArrayList_Groupe_0;
    }
}

