package com.example.mouad.kanjiapp;

public class Katakana extends Charactere {

    public Katakana(String charactere, int numero, String signification) {
        super(charactere, numero, signification);
    }

    @Override
    public String getCharactere() {
        return charactere;
    }

    @Override
    public int getNumero() {
        return numero;
    }

    @Override
    public String getSignification() {
        return signification;
    }
}
