package com.example.cpre388.whack_a_mole.Models;

/**
 * Mole Model, contains methods to set if the mole is currently active.
 * If active, and the user selects the corresponding mole on the activity - it will mark a point.
 */
public class moleModel{
    //Tracks if Mole is active
    private boolean isActive;

    /**
     * Initialize Mole Model
     */
    public moleModel(){
        isActive = false;
    }

    /**
     * Sets Mole to active
     */
    public void setActive() {
        isActive = true;
    }

    /**
     * Clears the Mole
     */
    public void clear(){
        isActive = false;
    }

    /**
     * Return the mole status
     * @return : indicates if the mole is active for points!
     */
    public boolean getMole(){
        return isActive;
    }
}
