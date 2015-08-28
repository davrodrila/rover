package com.davrodrila.rover.beans.orientation;

import com.davrodrila.rover.beans.Coordinates;

/**
 * Created by David on 28/08/2015.
 */
public class EastState implements iOrientationState {

    @Override
    public iOrientationState turnLeft() {
        return new NorthState();
    }

    @Override
    public iOrientationState turnRight() {
        return new SouthState();
    }

    @Override
    public String getCardinalLetter() {
        return "E";
    }

    @Override
    public Coordinates getMovementVector() {
         return new Coordinates(1,0);
    }
}
