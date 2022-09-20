package com.example.cpre388.whack_a_mole.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cpre388.whack_a_mole.R;
import com.example.cpre388.whack_a_mole.Models.moleModel;
import com.example.cpre388.whack_a_mole.Models.userModel;
/**
 * Game Activity for the Application.
 */
public class gameActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.cpre388.whack_a_mole.MESSAGE";
    public static final String PLAYER_NAME = "com.example.cpre388.whack_a_mole.PLAYER";
    public static final String PLAYER_SCORE = "com.example.cpre388.whack_a_mole.SCORE";

    //Time Values:
    private long systemTime, runningTime;
    //Handler Objects:
    private Handler handler;
    private Handler check;
    private Random moleSelect;
    private int selected;
    private String exit;
    //Mole Objects:
    moleModel moleOne; moleModel moleTwo;moleModel moleThree;
    moleModel moleFour;moleModel moleFive;moleModel moleSix;
    moleModel moleSeven;moleModel moleEight;moleModel moleNine;
    moleModel moleTen;
    //User Object:
    userModel currentUser;
    //High Score Vars:
    SharedPreferences leader;
    private final String PREFERENCE_FILE_KEY = "com.example.cpre388.whack_a_mole.Activities";
    private final String PLAYER = "User";
    private final String SCORES = "Scores";
    private final int saved_high_score_default_key = 0;
    //View Objects:
    ImageView mole1;ImageView mole2;ImageView mole3;ImageView mole4;
    ImageView mole5;ImageView mole6;ImageView mole7;ImageView mole8;
    ImageView mole9;ImageView mole10;TextView user; TextView score;
    TextView leaderBoard;
    //Sound Effects:
    MediaPlayer wonk;
    MediaPlayer bruh;

    /**
     * onCreate() methods for this activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //High Score:
        leader = getSharedPreferences(PREFERENCE_FILE_KEY, MODE_PRIVATE);
        String highScore = leader.getString(SCORES, "");
        String player = leader.getString(PLAYER, "");
        String set = String.format("HI: %s", highScore);

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

        //Texts:
        user = findViewById(R.id.user);
        score = findViewById(R.id.score_board);
        leaderBoard = findViewById(R.id.hiscore);
        leaderBoard.setText(set);

        //Audio:
        wonk = MediaPlayer.create(gameActivity.this, R.raw.wonk);
        bruh = MediaPlayer.create(gameActivity.this, R.raw.bruh);

        //initializes the moles:
        moleOne = new moleModel();
        moleTwo = new moleModel();
        moleThree = new moleModel();
        moleFour = new moleModel();
        moleFive = new moleModel();
        moleSix = new moleModel();
        moleSeven = new moleModel();
        moleEight = new moleModel();
        moleNine = new moleModel();
        moleTen = new moleModel();

        //Set's the Username and initializes the current user:
        Intent intent = getIntent();
        String name = intent.getStringExtra(authActivity.EXTRA_MESSAGE);
        currentUser = new userModel(name, 3);

        //initialize two handler objects:
        handler = new Handler();
        check = new Handler();

        //sets up game defaults:
        String text = String.format("%s - %d", currentUser.getName(), currentUser.getLivesLeft());
        user.setText(text);
        setInitialHoles();
        clearAllMoles();

        //initialize handler, time
        selected = 0;
        systemTime = SystemClock.uptimeMillis();
        check.postAtTime(health, systemTime);
        handler.postAtTime(moles, systemTime);
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

    /**
     * Clears all of the available Mole's Active Status
     */
    public void clearAllMoles(){
        moleOne.clear();
        moleTwo.clear();
        moleThree.clear();
        moleFour.clear();
        moleFive.clear();
        moleSix.clear();
        moleSeven.clear();
        moleEight.clear();
        moleNine.clear();
        moleTen.clear();
    }

    /**
     * First Mole onPress() Method
     * @param view
     */
    public void onMoleOne(View view){
        Boolean check = moleOne.getMole();
        Boolean clicked = moleOne.isSelected();

        if(clicked == true){
            currentUser.doNothing();
        }
        else{
            if(check){
                wonk.start();
                currentUser.addPoint();
                moleOne.setClicked();
                setInitialHoles();
            }
            else{
                currentUser.doNothing();
            }
        }
    }

    /**
     * Second Mole onPress()Method
     * @param view
     */
    public void onMoleTwo(View view){
        Boolean check = moleTwo.getMole();
        Boolean clicked = moleTwo.isSelected();

        if(clicked == true){
            currentUser.doNothing();
        }
        else {
            if (check) {
                wonk.start();
                currentUser.addPoint();
                moleTwo.setClicked();
                setInitialHoles();
            } else {
                currentUser.doNothing();
            }
        }
    }

    /**
     * Third Mole onPress() method
     * @param view
     */
    public void onMoleThree(View view){
        Boolean check = moleThree.getMole();
        Boolean clicked = moleThree.isSelected();

        if(clicked == true){
            currentUser.doNothing();
        }
        else{
            if(check){
                wonk.start();
                currentUser.addPoint();
                moleThree.setClicked();
                setInitialHoles();
            }
            else{
                currentUser.doNothing();
            }
        }
    }

    /**
     * Fourth Mole onPress() method
     * @param view
     */
    public void onMoleFour(View view){
        Boolean check = moleFour.getMole();
        Boolean clicked = moleFour.isSelected();

        if(clicked == true){
            currentUser.doNothing();
        }
        else {
            if (check) {
                wonk.start();
                currentUser.addPoint();
                moleFour.setClicked();
                setInitialHoles();
            } else {
                currentUser.doNothing();
            }
        }
    }

    /**
     * Fifth Mole onPress() method
     * @param view
     */
    public void onMoleFive(View view){
        Boolean check = moleFive.getMole();
        Boolean clicked = moleFive.isSelected();

        if(clicked == true){
            currentUser.doNothing();
        }
        else {
            if (check) {
                wonk.start();
                currentUser.addPoint();
                moleFive.setClicked();
                setInitialHoles();
            } else {
                currentUser.doNothing();
            }
        }
    }

    /**
     * Sixth Mole onPress() Method
     * @param view
     */
    public void onMoleSix(View view){
        Boolean check = moleSix.getMole();
        Boolean clicked = moleSix.isSelected();

        if(clicked == true){
            currentUser.doNothing();
        }
        else {
            if (check) {
                wonk.start();
                currentUser.addPoint();
                moleSix.setClicked();
                setInitialHoles();
            } else {
                currentUser.doNothing();
            }
        }
    }

    /**
     * Seventh Mole onPress() method
     * @param view
     */
    public void onMoleSeven(View view){
        Boolean check = moleSeven.getMole();
        Boolean clicked = moleSeven.isSelected();
        if(clicked == true){
            currentUser.doNothing();
        }
        else {
            if (check) {
                wonk.start();
                currentUser.addPoint();
                moleSeven.setClicked();
                setInitialHoles();
            } else {
                currentUser.doNothing();
            }
        }
    }

    /**
     * Eighth Mole onPress() Method
     * @param view
     */
    public void onMoleEight(View view){
        Boolean check = moleEight.getMole();
        Boolean clicked = moleEight.isSelected();

        if(clicked == true){
            currentUser.doNothing();
        }
        else {
            if (check) {
                wonk.start();
                currentUser.addPoint();
                moleEight.setClicked();
                setInitialHoles();

            } else {
                currentUser.doNothing();
            }
        }
    }

    /**
     * Ninth Mole onPress() method
     * @param view
     */
    public void onMoleNine(View view){
        Boolean check = moleNine.getMole();
        Boolean clicked = moleNine.isSelected();

        if(clicked == true){
            currentUser.doNothing();
        }
        else {
            if (check) {
                wonk.start();
                currentUser.addPoint();
                moleNine.setClicked();
                setInitialHoles();
            } else {
                currentUser.doNothing();
            }
        }
    }

    /**
     * Tenth Mole onPress() method
     * @param view
     */
    public void onMoleTen(View view){
        Boolean check = moleTen.getMole();
        Boolean clicked = moleTen.isSelected();

        if(clicked == true){
            currentUser.doNothing();
        }
        else {
            if (check) {
                wonk.start();
                currentUser.addPoint();
                moleTen.setClicked();
                setInitialHoles();
            } else {
                currentUser.doNothing();
            }
        }
    }

    /**
     * Updates the Display as well as increments the difficulty of the game
     */
    public Runnable health = new Runnable() {
        private int points, lives;
        private String name;
        private boolean isAlive;

        @Override
        public void run() {
            isAlive = currentUser.healthStatus();
            points = currentUser.getPoints();
            lives = currentUser.getLivesLeft();
            name = currentUser.getName();

            if(!isAlive){
                //Initialize Intent
                Intent end = new Intent(gameActivity.this, overActivity.class);
                exit = String.format("Final Score %d by %s", points, name);
                String mPoints = String.format("%d", points);
                //Pass of extra messages:
                end.putExtra(EXTRA_MESSAGE, exit);
                end.putExtra(PLAYER_NAME, name);
                end.putExtra(PLAYER_SCORE, mPoints);
                //Stops sound, in the event of continued spam
                bruh.stop();
                //start
                startActivity(end);
            }
            else{
                String scoreboard = String.format("Score:%d", points);
                String text = String.format("%s - %d", name, lives);

                score.setText(scoreboard);
                user.setText(text);

                //Difficulty Increments:
                if(points <= 5){
                    runningTime = 2250;
                }
                else if(points > 5 && points <= 10){
                    runningTime = 2000;
                }
                else if(points > 10 && points <= 15){
                    runningTime = 1750;
                }
                else if(points > 15 && points <= 20){
                    runningTime = 1500;
                }
                else{
                    runningTime = 1000;
                }
                check.postDelayed(this, 10);
            }
        }
    };

    /**
     * Activates Random Moles on an ever reducing span.
     */
    public Runnable moles = new Runnable() {

        @Override
        public void run() {
            //Check to see if the previously selected mole was clicked:
            switch (selected){
                case 1:
                    if(moleOne.isSelected()){
                        currentUser.doNothing();
                    }
                    else{
                        currentUser.lostLife();
                        bruh.start();
                    }
                    break;
                case 2:
                    if(moleTwo.isSelected()){
                        currentUser.doNothing();
                    }
                    else{
                        currentUser.lostLife();
                        bruh.start();
                    }
                    break;
                case 3:
                    if(moleThree.isSelected()){
                        currentUser.doNothing();
                    }
                    else{
                        currentUser.lostLife();
                        bruh.start();
                    }
                    break;
                case 4:
                    if(moleFour.isSelected()){
                        currentUser.doNothing();
                    }
                    else{
                        currentUser.lostLife();
                        bruh.start();
                    }
                    break;
                case 5:
                    if(moleFive.isSelected()){
                        currentUser.doNothing();
                    }
                    else{
                        currentUser.lostLife();
                        bruh.start();
                    }
                    break;
                case 6:
                    if(moleSix.isSelected()){
                        currentUser.doNothing();
                    }
                    else{
                        currentUser.lostLife();
                        bruh.start();
                    }
                    break;
                case 7:
                    if(moleSeven.isSelected()){
                        currentUser.doNothing();
                    }
                    else{
                        currentUser.lostLife();
                        bruh.start();
                    }
                    break;
                case 8:
                    if(moleEight.isSelected()){
                        currentUser.doNothing();
                    }
                    else{
                        currentUser.lostLife();
                        bruh.start();
                    }
                    break;
                case 9:
                    if(moleNine.isSelected()){
                        currentUser.doNothing();
                    }
                    else{
                        currentUser.lostLife();
                        bruh.start();
                    }
                    break;
                case 10:
                    if(moleTen.isSelected()){
                        currentUser.doNothing();
                    }
                    else{
                        currentUser.lostLife();
                        bruh.start();
                    }
                    break;
                default:
                    currentUser.doNothing();
            }

            if(!currentUser.healthStatus())
            {
                currentUser.doNothing();
            }
            else {
                //Clear Holes:
                setInitialHoles();
                clearAllMoles();
                //Select a new hole:
                moleSelect = new Random();
                selected = moleSelect.nextInt(9);
                selected++;

                //Set image and set the mole as active:
                switch (selected) {
                    case 1:
                        mole1.setImageResource(R.drawable.with_mole);
                        moleOne.setActive();
                        break;
                    case 2:
                        mole2.setImageResource(R.drawable.with_mole);
                        moleTwo.setActive();
                        break;
                    case 3:
                        mole3.setImageResource(R.drawable.with_mole);
                        moleThree.setActive();
                        break;
                    case 4:
                        mole4.setImageResource(R.drawable.with_mole);
                        moleFour.setActive();
                        break;
                    case 5:
                        mole5.setImageResource(R.drawable.with_mole);
                        moleFive.setActive();
                        break;
                    case 6:
                        mole6.setImageResource(R.drawable.with_mole);
                        moleSix.setActive();
                        break;
                    case 7:
                        mole7.setImageResource(R.drawable.with_mole);
                        moleSeven.setActive();
                        break;
                    case 8:
                        mole8.setImageResource(R.drawable.with_mole);
                        moleEight.setActive();
                        break;
                    case 9:
                        mole9.setImageResource(R.drawable.with_mole);
                        moleNine.setActive();
                        break;
                    case 10:
                        mole10.setImageResource(R.drawable.with_mole);
                        moleTen.setActive();
                        break;
                    default:
                        mole1.setImageResource(R.drawable.without_mole);
                }

                handler.postDelayed(this, runningTime);
            }
        }
    };
}
