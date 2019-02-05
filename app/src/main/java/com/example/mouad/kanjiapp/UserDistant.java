package com.example.mouad.kanjiapp;

import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDistant extends AppCompatActivity implements Serializable {
    private int Id;
    private String EmailAddress;
    private String Password;
    private String Pseudo;

    public UserDistant(String EmailAddress, String Password, String Pseudo) {
        this.EmailAddress = EmailAddress;
        this.Password = Password;
        this.Pseudo = Pseudo;
    }

    public UserDistant() {
    }

    public int GetId() {
        return this.Id;
    }

    public String GetEmailAddress() {
        return this.EmailAddress;
    }

    public String GetPseudo() {
        return this.Pseudo;
    }


    public String GetPassword() {
        return this.Password;
    }


    public JSONArray convertToJSONArray() {
        List laliste = new ArrayList();
        laliste.add(EmailAddress);
        laliste.add(Password);
        laliste.add(Pseudo);
        return new JSONArray(laliste);
    }

}