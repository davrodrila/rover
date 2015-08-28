package com.davrodrila.rover.beans;

import com.davrodrila.rover.beans.orientation.*;

/**
 * Created by David on 28/08/2015.
 */
public class Rover {

    private Coordinates coordinates;
    private iOrientationState orientation;

    public Rover(Coordinates coordinates, String orientation) {
        this.coordinates = coordinates;
        this.orientation = setOrientationStateFromString(orientation);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getOrientation() {
        return orientation.getCardinalLetter();
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

    public Coordinates simulateMovement() {

        return this.getCoordinates().aggregateCoordinates(orientation.getMovementVector());
    }

    public void move() {
        this.coordinates = this.coordinates.aggregateCoordinates(orientation.getMovementVector());
    }
}
