package com.example.mouad.kanjiapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class SignInUserActivity extends AppCompatActivity implements Serializable {
    private static ArrayList<UserDistant> LesUserDistants;
    private static DistantAccess distantAccess;
    DataBaseHelper myDb;
    Button Create_Button;
    TextView Sign_Email;
    TextView Sign_Password;
    TextView Sign_Pseudo;
    Button OpenGallery;
    private int REQUEST_CODE = 1;
    String dede;
    Uri imageUri1;
    ImageView AvatarImage;
    Bitmap bitmap;
    User user;
    UserDistant userDistant;
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_sign_in);
        LesUserDistants = new ArrayList<UserDistant>();
        distantAccess = new DistantAccess();
        distantAccess.envoi("AllUsers", new JSONArray());
        myDb = new DataBaseHelper(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Create_Button = findViewById(R.id.Create_Button);
        Sign_Email = findViewById(R.id.Sign_Email);
        Sign_Password = findViewById(R.id.Sign_Password);
        AvatarImage = findViewById(R.id.AvatarImage);
        OpenGallery = findViewById(R.id.OpenGallery);
        Sign_Pseudo = findViewById(R.id.Sign_Pseudo);
    }

    public void OpenGallery(View v) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent.createChooser(intent, "Select Picture"), REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageView AvatarImage = findViewById(R.id.AvatarImage);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                AvatarImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void Create_Button(View v) {
        dede = String.valueOf(Utils.getBytes(bitmap));
        if (Sign_Email.getText().toString().trim().length() == 0 || Sign_Password.getText().toString().trim().length() == 0 || Sign_Pseudo.getText().toString().length() == 0) {
            Toast.makeText(SignInUserActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        } else {
            user = new User(Sign_Email.getText().toString(), Sign_Password.getText().toString(), Sign_Pseudo.getText().toString(), Utils.getBytes(bitmap));
            userDistant = new UserDistant("\"" + Sign_Email.getText().toString() + "\"", "\"" + Sign_Password.getText().toString() + "\"", "\"" + Sign_Pseudo.getText().toString() + "\"");
            for (UserDistant userDistant1 : LesUserDistants) {
                if (userDistant1.getEmailAddress().equals(user.getEmailAddress())) {
                    counter++;
                } else {

                }
            }
            if (counter >= 1) {
                Toast.makeText(SignInUserActivity.this, "The email or pseudo are already taken ", Toast.LENGTH_SHORT).show();
            } else {
                distantAccess.envoi("NewUser", userDistant.convertToJSONArray());
                myDb.InsertUser(user.getEmailAddress(), user.getPassword(), user.getPseudo(), Utils.getBytes(bitmap));
                myDb.close();
                Sign_Email.setText("EMAILAddress");
                Sign_Password.setText("Password");
                Toast.makeText(SignInUserActivity.this, "The user" + " " + user.getPseudo() + " " + "has been created", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignInUserActivity.this, LoginUserActivity.class);
                SignInUserActivity.this.startActivity(intent);
                startActivity(intent);
            }
        }
    }

    public ArrayList<UserDistant> getLesUserDistants() {
        return LesUserDistants;
    }

    public static void setLesUserDistants(ArrayList<UserDistant> lesUserDistants) {
        LesUserDistants = lesUserDistants;
    }

}