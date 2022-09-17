package com.example.cpre388.whack_a_mole.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cpre388.whack_a_mole.R;

/**
 * Game Activity for the Application.
 */
public class gameActivity extends AppCompatActivity {
    ImageView mole1;
    ImageView mole2;
    ImageView mole3;
    ImageView mole4;
    ImageView mole5;
    ImageView mole6;
    ImageView mole7;
    ImageView mole8;
    ImageView mole9;
    ImageView mole10;
    TextView user;

    /**
     * onCreate() methods for this activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //Assign ID's to our Objects:
        mole1 = findViewById(R.id.mole1);
        mole2 = findViewById(R.id.mole2);
        mole3 = findViewById(R.id.mole3);
        mole4 = findViewById(R.id.mole4);
        mole5 = findViewById(R.id.mole5);
        mole6 = findViewById(R.id.mole6);
        mole7 = findViewById(R.id.mole7);
        mole8 = findViewById(R.id.mole8);
        mole9 = findViewById(R.id.mole9);
        mole10 = findViewById(R.id.mole10);
        user = findViewById(R.id.user);

        Intent intent = getIntent();
        String name = intent.getStringExtra(authActivity.EXTRA_MESSAGE);

        //initialize game's objects:
        user.setText(name);
        setInitialHoles();
    }

    /**
     * Initializes the mole objects to an empty hole onCreate().
     */
    public void setInitialHoles(){
        //Set Initial Images Without the Mole.
        mole1.setImageResource(R.drawable.without_mole);
        mole2.setImageResource(R.drawable.without_mole);
        mole3.setImageResource(R.drawable.without_mole);
        mole4.setImageResource(R.drawable.without_mole);
        mole5.setImageResource(R.drawable.without_mole);
        mole6.setImageResource(R.drawable.without_mole);
        mole7.setImageResource(R.drawable.without_mole);
        mole8.setImageResource(R.drawable.without_mole);
        mole9.setImageResource(R.drawable.without_mole);
        mole10.setImageResource(R.drawable.without_mole);

    }
}
