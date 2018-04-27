package com.example.mouad.kanjiapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME =  "KanjiApp.db";
    public static final String TABLE_NAME    =  "Kanji_Table";

    public static final String COL_1         =  "ID";
    public static final String COL_2         =  "CHARACTERE";
    public static final String COL_3         =  "NUMERO";

    public static final String COL_4         =  "SIGNIFICATION";
    public static final String COL_5         =  "LECTURE_KUN";
    public static final String COL_6         =  "LECTURE_ON";
    public static final String COL_7         =  "JLPT_NIVEAU";

    private  static final String DATABASE_ALTER_TMODIF1 = "ALTER TABLE Kanji_Table ADD JLPT_NIVEAU_KANJI TEXT";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID  INTEGER PRIMARY KEY AUTOINCREMENT , CHARACTERE TEXT , NUMERO INTEGER , SIGNIFICATION TEXT , LECTURE_KUN TEXT , LECTURE_ON TEXT, JLPT_NIVEAU TEXT)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DATABASE_ALTER_TMODIF1);
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return  res;
    }

    public boolean InsertData(String character)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, character);
       long result = db.insert(TABLE_NAME, null, contentValues);
       if (result == -1)
           return false;
       else
           return true;
    }
}
