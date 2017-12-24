package com.example.mouad.kanjiapp;

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
    private int age;
    private float gg;

    public Test_Class(String name){
        this.name = getName();
    }

    public void salam(){
        System.out.println(getName());
    }
}
