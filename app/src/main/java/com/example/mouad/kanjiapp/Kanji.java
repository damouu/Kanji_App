package com.example.mouad.kanjiapp;


import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mouad on 29/12/2017.
 */

public class Kanji extends Charactere implements Serializable
{
    private String lecture_kenyon;
    private String lecture_onyomi;


    public Kanji(String charactere,   int numero,  String signification, String lecture_kunyomi, String lecture_onyomi)
    {
        super(charactere , numero , signification);
        this.lecture_kenyon   = lecture_kunyomi;
        this.lecture_onyomi   = lecture_onyomi;
    }

    @Override
    public  String getCharactere() {return charactere;}
    @Override
    public int getNumero() {
        return numero;
    }

    @Override
    public String getSignification() { return signification; }

    public String getLecture_kenyon()
    {
        return lecture_kenyon;
    }

    public String getLecture_onyomi()
    {
        return lecture_onyomi;
    }

    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    public void setLecture_kenyon(String lecture_kenyon)
    {
        this.lecture_kenyon = lecture_kenyon;
    }

    public void setLecture_onyomi(String lecture_onyomi)
    {
        this.lecture_onyomi = lecture_onyomi;
    }

    public void setSignification(String signification) {this.signification = signification; }

    public JSONArray convertToJSONArray(){
        List laliste = new ArrayList();
        laliste.add(charactere);
        laliste.add(numero);
        laliste.add(signification);
        laliste.add(lecture_kenyon);
        laliste.add(lecture_onyomi);
        return new JSONArray(laliste);
    }

}
