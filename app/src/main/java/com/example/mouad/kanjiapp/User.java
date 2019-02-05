package com.example.mouad.kanjiapp;

import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User extends AppCompatActivity implements Serializable {
    private String EmailAddress;
    private String Password;
    private String Pseudo;
    private byte[] Avatar;
    private String RandomValue;

    public User(String EmailAddress,String Password,String Pseudo, byte[] Avatar, String RandomValue) {
        this.EmailAddress = EmailAddress;
        this.Password = Password;
        this.Pseudo = Pseudo;
        this.Avatar = Avatar;
        this.RandomValue = RandomValue;
    }

    public User() { }

    public String getEmailAddress() { return this.EmailAddress; }

    public String getPseudo() { return this.Pseudo; }

    public byte[] getAvatar() { return this.Avatar; }

    public String getPassword() { return this.Password; }

    public String GetRandomValue() { return this.RandomValue; }

    public JSONArray convertToJSONArray() {
        List laliste = new ArrayList();
        laliste.add(EmailAddress);
        laliste.add(Pseudo);
        laliste.add(Avatar);
        laliste.add(Password);
        laliste.add(RandomValue);
        return new JSONArray(laliste);
    }

}