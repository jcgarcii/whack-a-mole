package com.example.cpre388.whack_a_mole.Activities;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;
import com.example.cpre388.whack_a_mole.R;


/**
 * Authentication Activity simply collects a username for leaderboard tracking.
 * Takes user input - then proceeds to launch the main game activity.
 */
public class authActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.cpre388.whack_a_mole.MESSAGE";
    ImageView logo;
    EditText name;
    MediaPlayer music;

    /**
     * Activity's onCreate() method
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        //Assign ID's to our objects:
        logo = findViewById(R.id.moleLogo);
        music = MediaPlayer.create(authActivity.this, R.raw.enter_name);
        name = findViewById(R.id.editTextTextPersonName);
        //Set Logo
        logo.setImageResource(R.drawable.mole_main);
        //Start Music:
        music.start();
    }

    /**
     * Button Listener - takes username input and starts the game activity.
     * @param view
     */
    public void onNameEntered(View view){
        //Initialize Intent
        Intent game = new Intent(this, gameActivity.class);
        music.stop();
        //EditText, String:
        String mName = name.getText().toString();
        //puts extra, starts game activity:
        game.putExtra(EXTRA_MESSAGE, mName);
        startActivity(game);
    }
}
