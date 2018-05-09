package com.example.mouad.kanjiapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest
{
    @Test
    public void addition_isCorrect() throws Exception
    {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getting_kanji_meaning()
    {
        Kanji z = new Kanji("zizi",1,"dede","dede","manger");
        Kanji k = new Kanji("zizi",1,"dede","dede","manger");
        assertEquals(k,k);
    }




}