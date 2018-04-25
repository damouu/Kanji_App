package com.example.mouad.kanjiapp;

import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;

/**
 * Created by mouad on 29/12/2017.
 */

public class Kanji extends Charactere implements Serializable
{

    private String kanji;
    private int    numero;
    private String lecture_kenyon;
    private String lecture_onyomi;
    private String signification;
    private String charactere;

    public Kanji()
    {
            super();
    }

    public Kanji(String kanji, int numero, String lecture_kunyomi, String lecture_onyomi , String signification)
    {
        this.kanji           = kanji;
        this.numero          = numero;
        this.lecture_kenyon  = lecture_kunyomi;
        this.lecture_onyomi  = lecture_onyomi;
        this.signification   = signification;

    }

    public  String getCharactere() {return charactere;}

    public String getKanji() { return kanji; }

    public void setKanji(String kanji) {this.kanji = kanji;}

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    public String getLecture_kenyon()
    {
        return lecture_kenyon;
    }

    public void setLecture_kenyon(String lecture_kenyon)
    {
        this.lecture_kenyon = lecture_kenyon;
    }

    public String getLecture_onyomi()
    {
        return lecture_onyomi;
    }

    public void setLecture_onyomi(String lecture_onyomi)
    {
        this.lecture_onyomi = lecture_onyomi;
    }

    public String getSignification()
    {
        return signification;
    }

    public void setSignification(String signification)
    {
        this.signification = signification;
    }

}
