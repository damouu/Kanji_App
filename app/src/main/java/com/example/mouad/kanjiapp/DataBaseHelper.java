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

    private  static final String DATABASE_ALTER_TMODIF1 = "ALTER TABLE Kanji_Table ADD JLPT_NIVEAU_KANJI TEXT";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID  INTEGER PRIMARY KEY AUTOINCREMENT , CHARACTERE TEXT , NUMERO INTEGER , SIGNIFICATION TEXT , LECTURE_KUN TEXT , LECTURE_ON TEXT)" );

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

    public  Cursor JLPT5_Kanji(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Kanji_Table WHERE NUMERO ='" + "JLPT5" +"'",null);
        return  res;
    }

    public  Cursor JLPT4_Kanji(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Kanji_Table WHERE NUMERO ='" + "JLPT4" +"'",null);
        return  res;
    }

    public  Cursor JLPT3_Kanji(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Kanji_Table WHERE NUMERO ='" + "JLPT3" +"'",null);
        return  res;
    }

    public  Cursor JLPT2_Kanji(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Kanji_Table WHERE NUMERO ='" + "JLPT2" +"'",null);
        return  res;
    }

    public  Cursor JLPT1_Kanji(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Kanji_Table WHERE NUMERO ='" + "JLPT1" +"'",null);
        return  res;
    }

    public void deleteData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,null,null);
        db.execSQL("DELETE  FROM " +TABLE_NAME);
        db.close();
    }
    public boolean InsertData(String CHARACTERE,String NUMERO,  String SIGNIFICATION , String LECTURE_KUN ,String LECTURE_ON )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, CHARACTERE);
        contentValues.put(COL_3, NUMERO);
        contentValues.put(COL_4, SIGNIFICATION);
        contentValues.put(COL_5, LECTURE_KUN);
        contentValues.put(COL_6, LECTURE_ON);
       long result = db.insert(TABLE_NAME, null, contentValues);
       if (result == -1)
           return false;
       else
           return true;
    }
}
