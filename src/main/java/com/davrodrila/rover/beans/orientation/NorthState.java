package com.davrodrila.rover.beans.orientation;

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
}
