package com.example.mouad.kanjiapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.net.Uri;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME          =  "KanjiApp.db";
    public static final String TABLE_NAME             =  "Kanji_Table";
    public static final String TABLE_NAME_HIRAGANA    =  "Hiragana_Table";
    public static final String TABLE_NAME_KATAKANA    =  "Katakana_Table";
    public static final String TABLE_NAME_USERS       =  "Users_Table";
    public static final String TABLE_NAME_Test_History = "Test_History";
    public static final String TABLE_NAME_Favorite_Kanji = "Favorite_Kanji";
    public static final String COL_1         =  "ID";
    public static final String COL_2         =  "CHARACTERE";
    public static final String COL_3         =  "NUMERO";
    public static final String COL_4         =  "SIGNIFICATION";
    public static final String COL_5         =  "LECTURE_KUN";
    public static final String COL_6         =  "LECTURE_ON";
    public static final String COL_10        =  "EmailAddress";
    public static final String COL_11       =  "Password";
    public static final String COL_12       =   "Pseudo";
    public static final String COL_13       =   "Avatar";
    public static final String COL_14       =   "RandomValue";
    public static final String COL_15       =   "NIVEAU_JLPT_TEST_KANJI";
    public static final String COL_18       =   "DATE_TEST";
    public static final String COL_16       =   "SCORE";
    public static final String COL_17       =   "EmailAddress";
    public static final String COL_20       =   "ID";
    public static final String COL_21       =   "Kanji";
    public static final String COL_22       =   "User_Pseudo";
    public static final String COL_23       =   "Date_Added";


    private  static final String DATABASE_ALTER_TMODIF1 = "ALTER TABLE Kanji_Table ADD JLPT_NIVEAU_KANJI TEXT";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 52);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID  INTEGER PRIMARY KEY AUTOINCREMENT , CHARACTERE TEXT , NUMERO INTEGER , SIGNIFICATION TEXT , LECTURE_KUN TEXT , LECTURE_ON TEXT)" );
        db.execSQL("create table " + TABLE_NAME_USERS +" (ID  INTEGER PRIMARY KEY AUTOINCREMENT , EmailAddress TEXT ,Password TEXT ,Pseudo TEXT ,Avatar BLOB,RandomValue TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       //db.execSQL("create table " + TABLE_NAME_USERS +" (ID  INTEGER PRIMARY KEY AUTOINCREMENT , EmailAddress TEXT ,Password TEXT ,Pseudo TEXT ,Avatar BLOB,RandomValue TEXT )");
        //db.execSQL("create table " + TABLE_NAME_KATAKANA +" (ID  INTEGER PRIMARY KEY AUTOINCREMENT , CHARACTERE TEXT , NUMERO INTEGER , SIGNIFICATION TEXT )");
        //db.execSQL("create table " + TABLE_NAME_HIRAGANA +" (ID  INTEGER PRIMARY KEY AUTOINCREMENT , CHARACTERE TEXT , NUMERO INTEGER , SIGNIFICATION TEXT )");
        //db.execSQL("create table " + TABLE_NAME_Test_History +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NIVEAU_JLPT_TEST_KANJI TEXT,DATE_TEST DATE,SCORE INTEGER,EmailAddress TEXT ,FOREIGN KEY (EmailAddress) REFERENCES " + TABLE_NAME_USERS + " (EmailAddress))");
        //db.execSQL("create table " + TABLE_NAME_Favorite_Kanji +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Kanji TEXT,Date_Added DATE,User_Pseudo TEXT,FOREIGN KEY (Kanji) REFERENCES " + TABLE_NAME + " (CHRACTERE),FOREIGN KEY (User_Pseudo) REFERENCES " + TABLE_NAME_USERS + "(Pseudo))");
        //db.execSQL("DELETE FROM " + TABLE_NAME_USERS);
        //db.execSQL("DELETE FROM " + TABLE_NAME_Test_History);
        //db.execSQL("DELETE FROM " + TABLE_NAME_Favorite_Kanji);
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return  res;
    }

    public Cursor get_Hiragana(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME_HIRAGANA,null );
        return  res;
    }

    public Cursor get_Katakana(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME_KATAKANA,null );
        return  res;
    }

        public Cursor get_Hiragana_A(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Hiragana_Table WHERE NUMERO ='" + "A" +"'",null);
        return  res;
    }


    public Cursor get_Hiragana_Ka(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Hiragana_Table WHERE NUMERO ='" + "Ka" +"'",null);
        return  res;
    }

    public Cursor get_Katakana_A(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Katakana_Table WHERE NUMERO ='" + "A" +"'",null);
        return  res;
    }

    public Cursor get_Katakana_Ka(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Katakana_Table WHERE NUMERO ='" + "Ka" +"'",null);
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

    public void delete_HIRAGANA(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,null,null);
        db.execSQL("DELETE  FROM " +TABLE_NAME_HIRAGANA);
        db.close();
    }

    public void delete_KATAKANA(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,null,null);
        db.execSQL("DELETE  FROM " +TABLE_NAME_KATAKANA);
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

    public boolean InsertUser(String EmailAddress,String Password,String Pseudo,byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_10, EmailAddress);
        contentValues.put(COL_11, Password);
        contentValues.put(COL_12, Pseudo);
        contentValues.put(COL_13, image);
        long result = db.insert(TABLE_NAME_USERS, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor CheckFavoriteKanji(String Kanji,String User_Pseudo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT Kanji,User_Pseudo FROM Favorite_Kanji WHERE Kanji = '" + Kanji +"'" + " AND User_Pseudo ='" + User_Pseudo + "'",null);
        return res;
    }

    public boolean InsertFavoriteKanji(String Kanji,String User_Pseudo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_21, Kanji);
        contentValues.put(COL_22, User_Pseudo);
        contentValues.put(COL_23, getDateTime());
        long result = db.insert(TABLE_NAME_Favorite_Kanji, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }


    public void DeleteFavoriteKanji(String Kanji,String User_Pseudo) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+ TABLE_NAME_Favorite_Kanji + " WHERE Kanji ='" + Kanji +"'" + " AND User_Pseudo ='" + User_Pseudo +"'");
    }


    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }


    public boolean InsertTest(String NIVEAU_JLPT_TEST_KANJI , int SCORE , String EmailAddress){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_15, NIVEAU_JLPT_TEST_KANJI);
        contentValues.put(COL_16, SCORE);
        contentValues.put(COL_17, EmailAddress);
        contentValues.put(COL_18, getDateTime());
        long result = db.insert(TABLE_NAME_Test_History, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }


    public Cursor GetUserHistoric(String EmailAddress){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT NIVEAU_JLPT_TEST_KANJI,DATE_TEST,SCORE FROM Test_History WHERE EmailAddress = '" + EmailAddress + "'",null);
        return  res;
    }

    public Cursor LogUser(String LogInMail,String LogInPassword){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT EmailAddress,Password,Pseudo,Avatar FROM Users_Table WHERE EmailAddress = '" + LogInMail +"'" + " AND Password ='" + LogInPassword +"'",null);
        return  res;
    }


    public Cursor CheckUser(String LogInMail,String Pseudo2){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT EmailAddress,Pseudo FROM Users_Table WHERE EmailAddress = '" + LogInMail +"'" + " AND Pseudo ='" + Pseudo2 + "'",null);
        return  res;
    }

    public boolean Insert_Hiragana(String CHARACTERE,String NUMERO,  String SIGNIFICATION)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, CHARACTERE);
        contentValues.put(COL_3, NUMERO);
        contentValues.put(COL_4, SIGNIFICATION);
        long result = db.insert(TABLE_NAME_HIRAGANA, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean Insert_Katakana(String CHARACTERE,String NUMERO,  String SIGNIFICATION)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, CHARACTERE);
        contentValues.put(COL_3, NUMERO);
        contentValues.put(COL_4, SIGNIFICATION);
        long result = db.insert(TABLE_NAME_KATAKANA, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}
