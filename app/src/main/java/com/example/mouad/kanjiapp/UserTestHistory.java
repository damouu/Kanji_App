package com.example.mouad.kanjiapp;

import android.support.v7.app.AppCompatActivity;

import java.util.Date;

public class UserTestHistory extends AppCompatActivity {
    private String NiveauJLPTTestKanji;
    private String DateTest;
    private Integer Score;
    private String EmailAddress;

    public UserTestHistory(String NiveauJLPTTestKanji , String DateTest, Integer Score, String EmailAddress){
        this.NiveauJLPTTestKanji = NiveauJLPTTestKanji;
        this.DateTest = DateTest;
        this.Score = Score;
        this.EmailAddress = EmailAddress;
    }


    public String toString1(){
        return this.NiveauJLPTTestKanji;
    }

    public UserTestHistory(){}

    public String getNiveauJLPTTestKanji() { return NiveauJLPTTestKanji; }

    public void setNiveauJLPTTestKanji(String niveauJLPTTestKanji) { NiveauJLPTTestKanji = niveauJLPTTestKanji; }

    public String getDateTest() { return DateTest; }

    public Integer getScore() { return Score; }

    public void setScore(Integer score) { Score = score; }

    public String getEmailAddress() { return EmailAddress; }

    public void setEmailAddress(String emailAddress) { EmailAddress = emailAddress; }
}
