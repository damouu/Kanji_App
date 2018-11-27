package com.example.mouad.kanjiapp;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;



import java.text.DateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity
{
    DataBaseHelper myDb;
    EditText editText;
    EditText Time_TextView;
    Toolbar toolbar;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        actionBar.setHomeButtonEnabled(true);
        myDb = new DataBaseHelper(this);
        Button Admin_Button = findViewById(R.id.Admin_Button);
        Button button_KANJI = findViewById(R.id.button_KANJI);
        Button button_HIRAGANA = findViewById(R.id.button_HIRAGANA);
        Button button_KATAKANA = findViewById(R.id.button_KATAKANA);
        Button LogInButton = findViewById(R.id.LogIn);
        Button SignIn_button = findViewById(R.id.SignIn_button);
        Button LogOut_Button = findViewById(R.id.LogOut_Button);
        Button Button_Historic = findViewById(R.id.Button_Historic);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        TextView Time_TextView = findViewById(R.id.Time_TextView);
        Time_TextView.setText(currentDateTimeString);
        user = (User)getIntent().getSerializableExtra("user");
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        if(user != null ){
            TextView User_TextView = findViewById(R.id.User_TextView);
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view); View headerView = navigationView.getHeaderView(0);
            TextView navUsername = (TextView) headerView.findViewById(R.id.navUsername); navUsername.setText( user.GetPseudo());
            User_TextView.setText("Welcome back " + " " + user.GetPseudo());
            NavigationView navigationView2 = (NavigationView) findViewById(R.id.nav_view); View headerView2 = navigationView2.getHeaderView(0);
            TextView navUserEmail = (TextView) headerView2.findViewById(R.id.navUserEmail); navUserEmail.setText(user.GetEmailAddress());
            NavigationView navigationView3 = (NavigationView) findViewById(R.id.nav_view); View headerView3 = navigationView3.getHeaderView(0);
            NavigationView navigationView4 = (NavigationView) findViewById(R.id.nav_view); View headerView4 = navigationView4.getHeaderView(0);
            ImageView User_Avatar = (ImageView) headerView4.findViewById(R.id.imageView); User_Avatar.setImageBitmap(Utils.getImages(user.GetAvatar()));
            LogOut_Button.setVisibility(View.VISIBLE);
            Button_Historic.setVisibility(View.VISIBLE);
        }
    }

    public void buttonOnClick3 (View v){
        ImageButton personaButton = findViewById(R.id.imageButton2);
        personaButton.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this , Before_SecondScreen.class);
        }
        });
    }

    public void Button_Historic(View view){
        Button Button_Historic = findViewById(R.id.Button_Historic);
        Button_Historic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , Historic_Activity.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
    }

    public void LogOut_Button (View v ){
        Button LogOut_Button = findViewById(R.id.LogOut_Button);
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
                            TextView User_TextView = findViewById(R.id.User_TextView);
                            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view); View headerView = navigationView.getHeaderView(0);
                            TextView navUsername = (TextView) headerView.findViewById(R.id.navUsername); navUsername.setText("Hello guest");
                            NavigationView navigationView2 = (NavigationView) findViewById(R.id.nav_view); View headerView2 = navigationView2.getHeaderView(0);
                            TextView navUserEmail = (TextView) headerView2.findViewById(R.id.navUserEmail); navUserEmail.setText("Hello guest");
                            User_TextView.setText("Welcome guest");
                            NavigationView navigationView4 = (NavigationView) findViewById(R.id.nav_view); View headerView4 = navigationView4.getHeaderView(0);
                            ImageView User_Avatar = (ImageView) headerView4.findViewById(R.id.imageView); User_Avatar.setImageDrawable(getApplicationContext().getDrawable(R.drawable.bilalpng_96x96));
                            Toast.makeText(MainActivity.this,"You successfully logout",Toast.LENGTH_SHORT).show();
                            Button LogOut_Button = findViewById(R.id.LogOut_Button);
                            LogOut_Button.setVisibility(View.INVISIBLE);
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

    public void LogInButton (View v){
        Button LogInButton = findViewById(R.id.LogIn);
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , LoginPage.class);
                startActivity(intent);
            }
        });
    }

    public void SignIn_button (View v){
        Button SignIn_button = findViewById(R.id.SignIn_button);
        SignIn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this , SignIn.class);
                startActivity(intent);
            }
        });
    }

    public void personaPurple ( View v) {
        ImageButton personaPurple = findViewById(R.id.personaPurple);
        personaPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Learn_Kanji.class);
                startActivity(intent);
            }
        });
    }

    public void button_KANJI (View v){
        Button button_KANJI = findViewById(R.id.button_KANJI);
        Intent intent = new Intent(MainActivity.this, Kanji_HUB.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }

    public void button_HIRAGANA (View v){
        Button button_HIRAGANA = findViewById(R.id.button_HIRAGANA);
        Intent intent = new Intent(MainActivity.this, Hiragana_HUB.class);
        startActivity(intent);
    }

    public void button_KATAKANA (View v){
        Button button_KATAKANA = findViewById(R.id.button_KATAKANA);
        Intent intent = new Intent(MainActivity.this, Katakana_HUB.class);
        startActivity(intent);
    }

    public void Admin_Button (View v){
        Button Admin_Button = findViewById(R.id.Admin_Button);
        Intent intent = new Intent(MainActivity.this, Admin_Hub.class);
        startActivity(intent);
    }

    public void buttonOnClick1 (View v) {
        Button Click = findViewById(R.id.button);
        TextView ChampText = findViewById(R.id.textView);
        ChampText.setText(editText.getText());
        ((Button)v).setText("salam");
        Click.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.i("My app" , "do the magic");
                Toast.makeText(getApplicationContext(), "button has been Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void buttonOnClick2 (View v) {
        Toast.makeText(MainActivity.this,"UEUE ",Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,"NAN NAN ",Toast.LENGTH_SHORT).show();
        TextView ChampText = findViewById(R.id.textView);
        ChampText.setText(editText.getText());
        ImageButton Damou_Button = findViewById(R.id.Damou_Button);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Alerte");
        builder.setMessage("MASHALLAH ");
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener()

        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                dialogInterface.cancel();
                Log.i("GG","do the shit");
                Toast.makeText(getApplicationContext(), "my god !",Toast.LENGTH_SHORT).show();
            }

        });
        builder.show();
    }

}