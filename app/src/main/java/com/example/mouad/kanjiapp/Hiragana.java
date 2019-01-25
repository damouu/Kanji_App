package com.example.mouad.kanjiapp;

public class Hiragana extends Charactere {

    public Hiragana(String charactere, int numero, String signification) {
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
