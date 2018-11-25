package com.example.mouad.kanjiapp;

import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;

public class User extends AppCompatActivity implements Serializable
{
    private int Id;
    private String EmailAddress;
    private String Password;
    private String Pseudo;
    private byte[] Avatar;
    private String RandomValue;

    public User(String EmailAddress , String Pseudo, byte[] Avatar, String RandomValue)
    {
        this.EmailAddress = EmailAddress;
        this.Pseudo = Pseudo;
        this.Avatar = Avatar;
        this.RandomValue = RandomValue;
    }

    public User (){ }

    public int GetId() { return this.Id; }

    public String GetEmailAddress() { return this.EmailAddress; }

    public String GetPseudo() { return this.Pseudo; }

    public byte[] GetAvatar() { return this.Avatar; }

    public String GetPassword() { return this.Password; }

    public String GetRandomValue() { return this.RandomValue; }

}
