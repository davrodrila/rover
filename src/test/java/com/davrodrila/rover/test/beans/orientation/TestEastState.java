package com.davrodrila.rover.test.beans.orientation;

import com.davrodrila.rover.beans.orientation.*;
import org.junit.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by David on 29/08/2015.
 */
public class TestEastState {

    EastState state;

    @Before
    public void setState() {
        state = new EastState();
    }

    @Test
    public void whenFacingEastTurningLeftShouldMakeRoverFaceNorth() {

        assertTrue(state.turnLeft() instanceof NorthState);
    }

    @Test
    public void whenFacingEastTurningRightShouldMakeRoverFaceSouth() {
        assertTrue(state.turnRight() instanceof SouthState);
    }
}
