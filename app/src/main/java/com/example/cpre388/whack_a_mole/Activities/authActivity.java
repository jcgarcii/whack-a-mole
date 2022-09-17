package com.example.cpre388.whack_a_mole.Activities;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.cpre388.whack_a_mole.R;

/**
 * Authentication Activity simply collects a username for leaderboard tracking.
 * Takes user input - then proceeds to launch the main game activity.
 */
public class authActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.cpre388.whack_a_mole.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        ImageView logo = findViewById(R.id.moleLogo);

        //Initialize Logo on Auth screen:
        logo.setImageResource(R.drawable.mole_main);
    }

    public void onNameEntered(View view){
        //Initialize Intent
        Intent  game = new Intent(this, gameActivity.class);
        //EditText, String:
        EditText name = findViewById(R.id.editTextTextPersonName);
        String mName = name.getText().toString();
        //puts extra, starts game activity:
        game.putExtra(EXTRA_MESSAGE, mName);
        startActivity(game);

    }
}
