package com.davrodrila.rover.beans.orientation;

import com.davrodrila.rover.beans.Coordinates;

/**
 * Created by David on 28/08/2015.
 */
public class SouthState implements iOrientationState {

    @Override
    public iOrientationState turnLeft() {
        return new EastState();
    }

    @Override
    public iOrientationState turnRight() {
        return new WestState();
    }

    @Override
    public String getCardinalLetter() {
        return "S";
    }

    @Override
    public Coordinates getMovementVector() {
        return new Coordinates(0,-1);
    }
}
