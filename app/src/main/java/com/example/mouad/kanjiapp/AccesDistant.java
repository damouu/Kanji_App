package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AccesDistant implements AsyncResponse {

    private static final String SERVERADDR = "http://192.168.56.1/KanjiApp/serveurKanjiApp.php";
    ArrayList<Kanji> LesKanjisJSON = new ArrayList<Kanji>();
    ArrayList<Kanji> Kanji_JLPT5_JSONArray = new ArrayList<Kanji>();
    ArrayList<Kanji> Kanji_JLPT4_JSONArray = new ArrayList<Kanji>();
    ArrayList<Kanji> Kanji_JLPT3_JSONArray = new ArrayList<Kanji>();
    ArrayList<Kanji> Kanji_JLPT2_JSONArray = new ArrayList<Kanji>();
    ArrayList<Kanji> Kanji_JLPT1_JSONArray = new ArrayList<Kanji>();
    int i;

    public AccesDistant() {
        super();
    }

    @Override
    public void processFinish(String output) {
        Log.d("serveur", "*************************" + output);
        String[] message = output.split("%");
        if (message.length > 1) {
            if (message[0].equals("enreg")) {
                Log.d("enreg", "******************" + message[1]);
            } else {
                if (message[0].equals("TousLesKanjis")) {
                    Log.d("TousLesKanjis", "******************" + message[1]);
                    try {
                        JSONArray jsonInfo = new JSONArray(message[1]);
                        for (i = 0; i < jsonInfo.length(); i++) {
                            JSONObject info = new JSONObject(jsonInfo.get(i).toString());
                            Integer ID = info.getInt("ID");
                            String CHARACTERE = info.getString("CHARACTERE");
                            Integer JLPT_NUMERO = info.getInt("JLPT_NUMERO");
                            String SIGNIFICATION = info.getString("SIGNIFICATION");
                            String LECTURE_KUN = info.getString("LECTURE_KUN");
                            String LECTURE_ON = info.getString("LECTURE_ON");
                            Kanji kanji = new Kanji(CHARACTERE, JLPT_NUMERO, SIGNIFICATION, LECTURE_KUN, LECTURE_ON);
                            if (kanji.getNumero() == 5) {
                                Kanji_JLPT5_JSONArray.add(kanji);
                            }
                            if (kanji.getNumero() == 4) {
                                Kanji_JLPT4_JSONArray.add(kanji);
                            }
                            if (kanji.getNumero() == 3) {
                                Kanji_JLPT3_JSONArray.add(kanji);
                            }

                            if (kanji.getNumero() == 2) {
                                Kanji_JLPT2_JSONArray.add(kanji);
                            }

                            if (kanji.getNumero() == 1) {
                                Kanji_JLPT1_JSONArray.add(kanji);
                            }
                            LesKanjisJSON.add(kanji);
                        }
                        Admin.setLesKanjis(LesKanjisJSON);
                        Before_SecondScreen.setKanji_JLPT5_ArrayList(Kanji_JLPT5_JSONArray);
                        Before_SecondScreen.setKanji_JLPT4_ArrayList(Kanji_JLPT4_JSONArray);
                        Before_SecondScreen.setKanji_JLPT3_ArrayList(Kanji_JLPT3_JSONArray);
                        Before_SecondScreen.setKanji_JLPT2_ArrayList(Kanji_JLPT2_JSONArray);
                        Before_SecondScreen.setKanji_JLPT1_ArrayList(Kanji_JLPT1_JSONArray);
                    } catch (JSONException e) {
                        Log.d("erreur", "******************" + message[1]);
                    }
                }

                if (message[0].equals("NewUser")) {
                    Log.d("NewUser", "******************" + message[1]);
                }
            }
        }
    }
//dssdsd

    public void envoi(String operation, JSONArray lesDonneesJSON) {
        AccesHTTP accesDonnees = new AccesHTTP();
        accesDonnees.delegate = this;
        accesDonnees.addParam("operation", operation);
        accesDonnees.addParam("lesdonnees", lesDonneesJSON.toString());
        accesDonnees.execute(SERVERADDR);
    }
}