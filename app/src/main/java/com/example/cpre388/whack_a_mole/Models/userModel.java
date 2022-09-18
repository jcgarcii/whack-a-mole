package com.example.cpre388.whack_a_mole.Models;

/**
 * This model is used as the user model, it tracks the current points, lives left.
 */
public class userModel {
    //User Attributes:
    private String mName;
    private int points;
    private int livesLeft;
    private boolean isAlive;

    /**
     * Standard UserModel.
     * @param name : takes input name
     * @param lives : takes the amount of lives the user wants to set
     */
    public userModel(String name, int lives){
        this.mName = name;
        this.livesLeft = lives;
        this.points = 0;
        this.isAlive = true;
    }

    /**
     * Adds a point to the user on a successful hit
     */
    public void addPoint(){
        points = points + 1;
    }

    /**
     * Takes away a life point from a user on a failure
     */
    public void lostLife(){
        livesLeft = livesLeft - 1;
        if(livesLeft == 0){
            isAlive = false;
        }
        else{
            isAlive = true;
        }
    }

    /**
     * Gets the user name
     * @return mName : returns the name of the user
     */
    public String getName(){
        return mName;
    }

    /**
     * Returns the points of the user
     * @return points: current user points
     */
    public int getPoints(){
        return points;
    }

    /**
     * Returns the life points left of a user
     * @return livesLeft: amount of life points the user has left
     */
    public int getLivesLeft(){
        return livesLeft;
    }

    /**
     * Does nothing, used for when user hits a moleless hole and still has time
     */
    public void doNothing(){}

    /**
     * Checks to see if our user still has lifePoints;
     * @return isAlive: returns if user still has lifePoints left.
     */
    public boolean healthStatus(){
        return isAlive;
    }

}
