package com.example.cpre388.whack_a_mole.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.cpre388.whack_a_mole.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * The leadership activity for the application.
 */
public class statsActivity extends AppCompatActivity {
    private final String PREFERENCE_FILE_KEY = "com.example.cpre388.whack_a_mole.Activities";
    private final String PLAYER = "User";
    private final String SCORES = "Scores";
    private final int saved_high_score_default_key = 0;
    TextView leaderboard;
    SharedPreferences leader;
    /**
     * onCreate() class for this activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        leaderboard = findViewById(R.id.leaderboard);

        //Shared Preferences:
        leader = getSharedPreferences(PREFERENCE_FILE_KEY, MODE_PRIVATE);
        String highScore = leader.getString(SCORES, "");
        String player = leader.getString(PLAYER, "");
        String set = String.format("%s : %s", player, highScore);

        //String set = readFromFile(this);
        leaderboard.setText(set);
    }

    /*
     * Fetches input from a file:
     * @param context
     * @return
     *
    private String readFromFile(Context context) {
        String ret = "";
        try {
            InputStream inputStream = context.openFileInput("leaderboard.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);
                }
                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }*/
}
