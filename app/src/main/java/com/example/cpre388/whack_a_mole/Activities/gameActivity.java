package com.example.cpre388.whack_a_mole.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cpre388.whack_a_mole.R;

/**
 * Game Activity for the Application.
 */
public class gameActivity extends AppCompatActivity {

    /**
     * onCreate() methods for this activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //initialize holes:
        setInitialHoles();
    }

    /**
     * Initializes the mole objects to an empty hole onCreate().
     */
    public void setInitialHoles(){
        //Set Initial Images Without the Mole.
        //Assign ID's to ImageView.
        ImageView mole1 = findViewById(R.id.mole1);
        ImageView mole2 = findViewById(R.id.mole2);
        ImageView mole3 = findViewById(R.id.mole3);
        ImageView mole4 = findViewById(R.id.mole4);
        ImageView mole5 = findViewById(R.id.mole5);
        ImageView mole6 = findViewById(R.id.mole6);
        ImageView mole7 = findViewById(R.id.mole7);
        ImageView mole8 = findViewById(R.id.mole8);
        ImageView mole9 = findViewById(R.id.mole9);
        ImageView mole10 = findViewById(R.id.mole10);
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
