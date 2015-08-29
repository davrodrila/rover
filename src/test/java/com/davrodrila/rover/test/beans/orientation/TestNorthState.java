package com.davrodrila.rover.test.beans.orientation;

import com.davrodrila.rover.beans.orientation.*;
import org.junit.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by David on 29/08/2015.
 */
public class TestNorthState {
    NorthState state;

    @Before
    public void setState() {
        state = new NorthState();
    }

    @Test
    public void whenFacingNorthTurningLeftShouldMakeRoverFaceWest() {
        assertTrue(state.turnLeft() instanceof  WestState);
    }

    @Test
    public void whenFacingNorthTurningRightShouldMakeRoverFaceEast() {
        assertTrue(state.turnRight() instanceof EastState);
    }



}
