package com.davrodrila.rover.beans.orientation;

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
}
