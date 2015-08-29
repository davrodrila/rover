package com.davrodrila.rover.test.beans.orientation;

import com.davrodrila.rover.beans.orientation.*;
import org.junit.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by David on 29/08/2015.
 */
public class TestWestState {
    WestState state;

    @Before
    public void setState() {
        state = new WestState();
    }

    @Test
    public void whenFacingWestTurningLeftShouldMakeRoverFaceSouth() {
        assertTrue(state.turnLeft() instanceof  SouthState);
    }

    @Test
    public void whenFacingWestTurningRightShouldMakeRoverFaceNorth() {
        assertTrue(state.turnRight() instanceof  NorthState);
    }
}
