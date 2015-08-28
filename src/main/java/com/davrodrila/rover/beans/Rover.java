package com.davrodrila.rover.beans;

import com.davrodrila.rover.beans.orientation.*;

/**
 * Created by David on 28/08/2015.
 */
public class Rover {

    private int x;
    private int y;
    private iOrientationState orientation;

    public Rover(int x, int y, String orientation) {
        this.x = x;
        this.y = y;
        this.orientation = setOrientationStateFromString(orientation);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public iOrientationState getOrientation() {
        return orientation;
    }

    public void setOrientation(String state) {
        this.orientation = setOrientationStateFromString(state);
    }

    private iOrientationState setOrientationStateFromString(String state) {
        iOrientationState stateToReturn = null;
        if (state.equals("N")) {
            stateToReturn = new NorthState();
        } else if (state.equals("W")) {
            stateToReturn = new WestState();
        } else if (state.equals("S")) {
            stateToReturn = new SouthState();
        } else if (state.equals("E")) {
            stateToReturn = new EastState();
        }
        return stateToReturn;
    }

    public void turnLeft() {
        orientation = orientation.turnLeft();
    }

    public void turnRight() {
        orientation = orientation.turnRight();
    }

}
