package com.example.mouad.kanjiapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    private int REQUEST_CODE = 1;
    private static RemoteAccess remoteAccess;
    DataBaseHelper myDb;
    EditText editText;
    EditText Time_TextView;
    Toolbar toolbar;
    User user;
    Bitmap bitmap;
    Button LogInButton;
    Button Admin_Button;
    Button Kanji_Button;
    Button Hiragana_Button;
    Button Katakana_Button;
    Button SignIn_button;
    Button LogOut_Button;
    Button Favorite_Button;
    Button Historic_Button;
    Button ChangeAvatar_Button;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    TextView User_TextView;
    View headerView;
    TextView navUsername;
    NavigationView navigationView2;
    View headerView2;
    ImageButton personaButton;
    ImageView User_Avatar;
    TextView navUserEmail;
    NavigationView navigationView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        actionBar.setHomeButtonEnabled(true);
        myDb = new DataBaseHelper(this);
        Admin_Button = findViewById(R.id.Admin_Button);
        Kanji_Button = findViewById(R.id.button_KANJI);
        Hiragana_Button = findViewById(R.id.button_HIRAGANA);
        Katakana_Button = findViewById(R.id.button_KATAKANA);
        LogInButton = findViewById(R.id.LogIn);
        SignIn_button = findViewById(R.id.SignIn_button);
        LogOut_Button = findViewById(R.id.LogOut_Button);
        Favorite_Button = findViewById(R.id.Favorite_Button);
        Historic_Button = findViewById(R.id.Button_Historic);
        ChangeAvatar_Button = findViewById(R.id.Change_Avatar);
        personaButton = findViewById(R.id.personaPurple);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        TextView Time_TextView = findViewById(R.id.Time_TextView);
        Time_TextView.setText(currentDateTimeString);
        user = (User) getIntent().getSerializableExtra("user");
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        if (user != null) {
            User_TextView = findViewById(R.id.User_TextView);
            navigationView = findViewById(R.id.nav_view);
            headerView = navigationView.getHeaderView(0);
            navUsername = headerView.findViewById(R.id.navUsername);
            navUsername.setText(user.getPseudo());
            User_TextView.setText("Welcome back " + " " + user.getPseudo());
            navigationView2 = (NavigationView) findViewById(R.id.nav_view);
            headerView2 = navigationView2.getHeaderView(0);
            navigationView3 = findViewById(R.id.nav_view);
            NavigationView navigationView3 = findViewById(R.id.nav_view);
            View headerView3 = navigationView3.getHeaderView(0);
            NavigationView navigationView4 = (NavigationView) findViewById(R.id.nav_view);
            View headerView4 = navigationView4.getHeaderView(0);
            User_Avatar = (ImageView) headerView4.findViewById(R.id.imageView);
            User_Avatar.setImageBitmap(Utils.getImages(user.getAvatar()));
            LogOut_Button.setVisibility(View.VISIBLE);
            Historic_Button.setVisibility(View.VISIBLE);
            Favorite_Button.setVisibility(View.VISIBLE);
            ChangeAvatar_Button.setVisibility(View.VISIBLE);
            LogInButton.setVisibility(View.INVISIBLE);
            navUserEmail = headerView2.findViewById(R.id.navUserEmail);
            navUserEmail.setText(user.getEmailAddress());
        }
    }


    public void OpenGalleryMainActivity(View v) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent.createChooser(intent, "Select Picture"), REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                boolean isInserted = myDb.ChangeUserAvatar(user.getEmailAddress(), Utils.getBytes(bitmap));
                if (isInserted == true) {
                    Toast.makeText(MainActivity.this, "avatar changed successfully !", Toast.LENGTH_SHORT).show();
                    Cursor cursor = myDb.AvatarUser(user.getEmailAddress());
                    cursor.moveToFirst();
                    byte[] Avatar = cursor.getBlob(0);
                    NavigationView navigationView4 = (NavigationView) findViewById(R.id.nav_view);
                    View headerView4 = navigationView4.getHeaderView(0);
                    ImageView User_Avatar = (ImageView) headerView4.findViewById(R.id.imageView);
                    User_Avatar.setImageBitmap(Utils.getImages(Avatar));
                } else {
                    Toast.makeText(MainActivity.this, "A problem happened ", Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void Button_Historic(View view) {
        Historic_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Historic_Activity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }

    public void Favorite_Button(View view) {
        Favorite_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserFavoriteKanjiActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }

    public void LogOut_Button(View v) {
        LogOut_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Do you really want to logout ?");
                builder.setMessage("Logout ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        user = null;
                        View headerView2 = navigationView2.getHeaderView(0);
                        navUserEmail = headerView2.findViewById(R.id.navUserEmail);
                        User_TextView = findViewById(R.id.User_TextView);
                        navigationView3 = findViewById(R.id.nav_view);
                        navigationView = findViewById(R.id.nav_view);
                        navUsername = headerView.findViewById(R.id.navUsername);
                        navigationView2 = findViewById(R.id.nav_view);
                        headerView = navigationView.getHeaderView(0);
                        navUsername.setText("Hello guest");
                        navUserEmail.setText("Hello guest");
                        User_TextView.setText("Welcome guest");
                        NavigationView navigationView4 = (NavigationView) findViewById(R.id.nav_view);
                        View headerView4 = navigationView4.getHeaderView(0);
                        User_Avatar = headerView4.findViewById(R.id.imageView);
                        User_Avatar.setImageDrawable(getApplicationContext().getDrawable(R.drawable.bilalpng_96x96));
                        Toast.makeText(MainActivity.this, "You successfully logout", Toast.LENGTH_SHORT).show();
                        LogOut_Button.setVisibility(View.INVISIBLE);
                        LogInButton.setVisibility(View.VISIBLE);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

    }

    public void LogInButton(View v) {
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginUserActivity.class);
                startActivity(intent);
            }
        });
    }

    public void SignIn_button(View v) {
        SignIn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignInUserActivity.class);
                startActivity(intent);
            }
        });
    }

    public void personaPurple(View v) {
        personaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Learn_Kanji.class);
                startActivity(intent);
            }
        });
    }

    public void button_KANJI(View v) {
        Kanji_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Kanji_HUB.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }

    public void button_HIRAGANA(View v) {
        Hiragana_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Hiragana_HUB.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }

    public void button_KATAKANA(View v) {
        Katakana_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Katakana_HUB.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }

    public void Admin_Button(View v) {
        Admin_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Admin.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }
}