package com.example.cpre388.whack_a_mole.Models;

/**
 * Mole Model, contains methods to set if the mole is currently active.
 * If active, and the user selects the corresponding mole on the activity - it will mark a point.
 */
public class moleModel{
    //Tracks if Mole is active
    private boolean isActive;
    private boolean selected;

    /**
     * Initialize Mole Model
     */
    public moleModel(){
        isActive = false;
        selected = false;
    }

    /**
     * Sets Mole to active
     */
    public void setActive() {
        isActive = true;
    }

    /**
     * Indicates if the mole has been clicked to prevent spam abuse
     */
    public void setClicked(){
        selected = true;
    }

    /**
     * Clears the Mole
     */
    public void clear(){
        isActive = false;
        selected = false;
    }

    /**
     * Return the mole status
     * @return : indicates if the mole is active for points!
     */
    public boolean getMole(){
        return isActive;
    }

    /**
     * Returns if the mole has been clicked
     * @return : selected - disallows the reclicking of a mole
     */
    public boolean isSelected() {
        return selected;
    }
}
