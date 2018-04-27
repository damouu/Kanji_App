package com.example.mouad.kanjiapp;

import java.io.Serializable;


public abstract class Charactere implements  IAppKanji , Serializable{
   protected String charactere;
   protected int    numero;
   protected String signification;

    public Charactere(String charactere, int numero ,String signification )
    {
        this.charactere     =   charactere;
        this.numero         =   numero;
        this.signification  =   signification;
    }

    public  abstract String getCharactere();
    public  abstract int    getNumero();
    public  abstract String getSignification();
}
