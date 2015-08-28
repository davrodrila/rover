package com.davrodrila.rover.beans.orientation;

import com.davrodrila.rover.beans.Coordinates;

/**
 * Created by David on 28/08/2015.
 */
public interface iOrientationState {

    public iOrientationState turnLeft();

    public iOrientationState turnRight();

    public String getCardinalLetter();

    public Coordinates getMovementVector();
}
