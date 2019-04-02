package com.example.mouad.kanjiapp;

import android.widget.ArrayAdapter;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Test_history {
    private String NIVEAU_JLPT_TEST_KANJI;
    private int SCORE;
    private String EmailAddress;
    ArrayAdapter adapter;


    public Test_history (String NIVEAU_JLPT_TEST_KANJI,int SCORE,String EmailAddress){
        this.NIVEAU_JLPT_TEST_KANJI=NIVEAU_JLPT_TEST_KANJI;
        this.SCORE=SCORE;
        this.EmailAddress=EmailAddress;
    }

        public JSONArray convertToJSONArray() {
        List laliste = new ArrayList();
        laliste.add(NIVEAU_JLPT_TEST_KANJI);
        laliste.add(SCORE);
        laliste.add(EmailAddress);
        return new JSONArray(laliste);
    }


    public String getNIVEAU_JLPT_TEST_KANJI() {
        return NIVEAU_JLPT_TEST_KANJI;
    }

    public void setNIVEAU_JLPT_TEST_KANJI(String NIVEAU_JLPT_TEST_KANJI) {
        this.NIVEAU_JLPT_TEST_KANJI = NIVEAU_JLPT_TEST_KANJI;
    }

    public int getSCORE() {
        return SCORE;
    }

    public void setSCORE(int SCORE) {
        this.SCORE = SCORE;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }
}
