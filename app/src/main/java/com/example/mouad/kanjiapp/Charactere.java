package com.example.mouad.kanjiapp;

public abstract class Charactere implements  IAppKanji{
    private String charactere;
    private String signification;
    private String lecture_on;
    private String lecture_kenyon;

    public  abstract String getCharactere();
    public  abstract String getSignification();
    public  abstract String getLecture_kenyon();
    public  abstract String getLecture_onyomi();
}
