package com.example.mouad.kanjiapp;

import android.text.Editable;

/**
 * Created by mouad on 24/12/2017.
 */

public class Test_Class extends MainActivity {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public float getGg() {
        return gg;
    }

    public void setGg(float gg) {
        this.gg = gg;
    }

    private float gg;

    public boolean isNature() {
        return nature;
    }

    public void setNature(boolean nature) {
        this.nature = nature;
    }

    private boolean nature;


    public Test_Class() {

    }

    public Test_Class(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void salam() {
        System.out.println("salam" + getName());
    }
}
