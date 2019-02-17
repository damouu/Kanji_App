package com.example.mouad.kanjiapp;

public class Hiragana extends Charactere {
    private String GroupeHiragana;

    public Hiragana(String charactere, int numero, String signification,String GroupeHiragana) {
        super(charactere, numero, signification);
        this.GroupeHiragana = GroupeHiragana;
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


    public String getGroupeHiragana() { return GroupeHiragana; }

    public void setGroupeHiragana(String groupeHiragana) { GroupeHiragana = groupeHiragana; }
}
