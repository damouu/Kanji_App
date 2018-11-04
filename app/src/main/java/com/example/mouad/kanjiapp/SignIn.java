package com.example.mouad.kanjiapp;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class SignIn extends AppCompatActivity implements Serializable {
    DataBaseHelper myDb;
    Button Create_Button;
    private int REQUEST_CODE =1;
    Uri imageUri1;
    ImageView AvatarImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        myDb = new DataBaseHelper(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button Create_Button = findViewById(R.id.Create_Button);
        TextView Sign_Email = findViewById(R.id.Sign_Email);
        TextView Sign_Password = findViewById(R.id.Sign_Password);
        ImageView AvatarImage = findViewById(R.id.AvatarImage);
        Button OpenGallery = findViewById(R.id.OpenGallery);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void OpenGallery (View v){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent.createChooser(intent,"Select Picture"),REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        ImageView AvatarImage = findViewById(R.id.AvatarImage);
        super.onActivityResult(requestCode, resultCode,data);
        if(requestCode == REQUEST_CODE  && data != null && data.getData() != null){
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                AvatarImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void Create_Button (View v){
        Button Create_Button = findViewById(R.id.Create_Button);
        TextView Sign_Email = findViewById(R.id.Sign_Email);
        TextView Sign_Password = findViewById(R.id.Sign_Password);
        TextView Sign_Pseudo = findViewById(R.id.Sign_Pseudo);
        if(Sign_Email.getText().toString().trim().length() == 0 || Sign_Password.getText().toString().trim().length() == 0 || Sign_Pseudo.getText().toString().length() == 0){
            Toast.makeText(SignIn.this,"Please fill all the fields",Toast.LENGTH_SHORT).show();
        }
        else {
            boolean isInserted = myDb.InsertUser(Sign_Email.getText().toString(),Sign_Password.getText().toString(),Sign_Pseudo.getText().toString());
            if (isInserted == true) {
                Toast.makeText(SignIn.this, "The user" + " " + Sign_Email.getText().toString() + " " + "has been created", Toast.LENGTH_SHORT).show();
                Sign_Email.setText("EMAILAddress");
                Sign_Password.setText("Password");
                Sign_Pseudo.setText("Pseudo");
            } else {
                Toast.makeText(SignIn.this, "Une erreure s'est produite", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
