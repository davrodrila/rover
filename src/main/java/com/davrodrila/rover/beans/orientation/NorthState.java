package com.davrodrila.rover.beans.orientation;

import com.davrodrila.rover.beans.Coordinates;

/**
 * Created by David on 28/08/2015.
 */
public class NorthState implements iOrientationState{

    @Override
    public iOrientationState turnLeft() {
        return new WestState();
    }

    @Override
    public iOrientationState turnRight() {
        return new EastState();
    }

    @Override
    public String getCardinalLetter() {
        return "N";
    }

    @Override
    public Coordinates getMovementVector() {
        return new Coordinates(0,1);
    }
}
