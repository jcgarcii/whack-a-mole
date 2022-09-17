package com.example.cpre388.whack_a_mole.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.cpre388.whack_a_mole.R;
import com.example.cpre388.whack_a_mole.R.raw;

/**
 * This is the title card activity for the application.
 * Sets the Application's music and is a centralized hub for the other activities.
 */
public class MainActivity extends AppCompatActivity {
MediaPlayer music;
ImageView logo;

    /**
     * onCreate() class for this activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set Music, Logo:
        music = MediaPlayer.create(MainActivity.this, R.raw.background_music);
        logo = findViewById(R.id.moleLogo);
        logo.setImageResource(R.drawable.mole_main);

        music.start();

    }

    /**
     * Initializes the Authentication Activity when the WHACK! Button is Pressed.
     * @param view for the current View object.
     */

    public void onWhackPressed(View view){
        Intent auth = new Intent(MainActivity.this, authActivity.class);
        music.stop();
        startActivity(auth);
    }

    /**
     * Initializes the Statistics Activity when the Stats button is Pressed. .
     * @param view for the current View object.
     */
    public void onStatsPressed(View view){
        Intent stats = new Intent(MainActivity.this, gameActivity.class);
        music.stop();
        startActivity(stats);
    }


}