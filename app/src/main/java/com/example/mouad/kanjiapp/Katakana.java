package com.example.mouad.kanjiapp;

public class Katakana extends Charactere {
    private String GroupeKatakana;

    public Katakana(String charactere, int numero, String signification,String GroupeKatakana) {
        super(charactere, numero, signification);
        this.GroupeKatakana = GroupeKatakana;
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

    public String getGroupeKatakana() {
        return GroupeKatakana;
    }

    public void setGroupeKatakana(String groupeKatakana) {
        GroupeKatakana = groupeKatakana;
    }
}
