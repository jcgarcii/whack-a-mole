package com.example.cpre388.whack_a_mole.Activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.cpre388.whack_a_mole.R;

/**
 * Game Over Scree for the Application
 */
public class overActivity extends AppCompatActivity {
    TextView scoreboard;
    MediaPlayer music;

    /**
     * onCreate() method
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over);
        scoreboard = findViewById(R.id.final_display);
        Intent intent = getIntent();
        music = MediaPlayer.create(overActivity.this, R.raw.game_over);
        String previous = intent.getStringExtra(gameActivity.EXTRA_MESSAGE);
        scoreboard.setText(previous);
        music.start();
    }

    /**
     * Returns users home once pressed.
     * @param view : Passes current view object.
     */
    public void onHomePressed(View view){
        Intent home = new Intent(overActivity.this, MainActivity.class);
        music.stop();
        startActivity(home);
    }


}
