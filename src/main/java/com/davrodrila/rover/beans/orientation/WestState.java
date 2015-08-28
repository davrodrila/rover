package com.davrodrila.rover.beans.orientation;

/**
 * Created by David on 28/08/2015.
 */
public class WestState implements iOrientationState {

    @Override
    public iOrientationState turnLeft() {
        return new SouthState();
    }

    @Override
    public iOrientationState turnRight() {
        return new NorthState();
    }

    @Override
    public String getCardinalLetter() {
        return "W";
    }
}
