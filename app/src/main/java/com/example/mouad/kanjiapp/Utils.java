package com.example.mouad.kanjiapp;
import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
public class Utils {
    public static byte[] getBytes(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,0,stream);
        return stream.toByteArray();
    }
}
