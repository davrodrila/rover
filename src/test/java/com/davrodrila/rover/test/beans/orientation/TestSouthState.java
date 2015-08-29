package com.davrodrila.rover.test.beans.orientation;

import com.davrodrila.rover.beans.orientation.*;
import org.junit.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by David on 29/08/2015.
 */
public class TestSouthState {

    SouthState state;

    @Before
    public void setState() {
        state = new SouthState();
    }

    @Test
    public void whenFacingSouthTurningLeftShouldMakeRoverFaceEast() {
        assertTrue(state.turnLeft() instanceof  EastState);
    }

    @Test
    public void whenFacingSouthTurningRightShouldMakeRoverFaceWest() {
        assertTrue(state.turnRight() instanceof WestState);
    }

}
