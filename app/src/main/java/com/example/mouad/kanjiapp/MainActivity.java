package com.example.mouad.kanjiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lesalam() {
        System.out.println(" le salam aux freres");
    }

           Test_Class tete = new Test_Class("dede");



}

