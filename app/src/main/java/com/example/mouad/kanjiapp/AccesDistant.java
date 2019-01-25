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
                            LesKanjisJSON.add(kanji);
                        }
                    } catch (JSONException e) {
                        Log.d("erreur", "******************" + message[1]);
                    }
                } else {
                    if (message[0].equals("ERREUR")) {
                        Log.d("ERREUR", "******************" + message[1]);
                    }
                }
            }
        }
    }


    public void envoi(String operation, JSONArray lesDonneesJSON) {
        AccesHTTP accesDonnees = new AccesHTTP();
        accesDonnees.delegate = this;
        accesDonnees.addParam("operation", operation);
        accesDonnees.addParam("lesdonnees", lesDonneesJSON.toString());
        accesDonnees.execute(SERVERADDR);
    }
}
