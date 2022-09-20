package com.example.cpre388.whack_a_mole.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    SharedPreferences leader;
    Context context;
    private final String PREFERENCE_FILE_KEY = "com.example.cpre388.whack_a_mole.Activities.overActivity";
    private final String PLAYER = "User";
    private final String SCORES = "Scores";
    private final int saved_high_score_default_key = 0;

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
        context = overActivity.this;

        //Shared Preferences Setup:
        leader = context.getSharedPreferences(PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        int defaultValue = getResources().getInteger(saved_high_score_default_key);
        int previousHigh = leader.getInt(SCORES, defaultValue);
        SharedPreferences.Editor editor = leader.edit();

        //retrieve the extra strings
        String finalScore = intent.getStringExtra(gameActivity.EXTRA_MESSAGE);
        String player = intent.getStringExtra(gameActivity.PLAYER_NAME);
        String mScore = intent.getStringExtra(gameActivity.PLAYER_SCORE);
        int score = Integer.getInteger(mScore);

        //check if previous score is higher:
        if(previousHigh < score){
            editor.putInt(SCORES, score);
            editor.putString(PLAYER, player);
            editor.apply();
        }

        //set scoreboard
        scoreboard.setText(finalScore);
        music.start();
        //writeToFile(previous, this);
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

    /*
     * Outputs score onto output file
     * @param data
     * @param context

    private void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("leaderboard.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    } */
}
