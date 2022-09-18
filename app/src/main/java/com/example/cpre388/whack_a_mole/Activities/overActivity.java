package com.example.cpre388.whack_a_mole.Activities;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.cpre388.whack_a_mole.R;

import java.io.IOException;
import java.io.OutputStreamWriter;

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
        writeToFile(previous, this);
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

    /**
     * Outputs score onto output file
     * @param data
     * @param context
     */
    private void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("leaderboard.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
