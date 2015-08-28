package com.davrodrila.rover.test;

import com.davrodrila.rover.beans.Rover;
import com.davrodrila.rover.beans.orientation.*;
import org.junit.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by David on 28/08/2015.
 */
public class TestRover {

    Rover rover;


    @Test
    public void whenCreatingAnObjectWithTheNStringNorthStateShouldBeCreated() {
        rover = new Rover(1,1,"N");
        assertTrue(rover.getOrientation() instanceof NorthState);
    }

    @Test
    public void whenCreatingAnObjectWithTheSStringSouthStateShouldBeCreated() {
        rover = new Rover(1,1,"S");
        assertTrue(rover.getOrientation() instanceof SouthState);
    }

    @Test
    public void whenCreatingAnObjectWithTheEStringEastStateShouldBeCreated() {
        rover = new Rover(1,1,"E");
        assertTrue(rover.getOrientation() instanceof EastState);
    }

    @Test
    public void whenCreatingAnObjectWiththeWStringWeastStateShouldBeCreated() {
        rover = new Rover(1,1,"W");
        assertTrue(rover.getOrientation() instanceof WestState);
    }

    @Test
    public void whenFacingNorthTurningLeftShouldMakeRoverFaceWest() {
        rover = new Rover(1,1,"N");
        rover.turnLeft();
        assertTrue(rover.getOrientation() instanceof WestState);
    }

    @Test
    public void whenFacingNorthTurningRightShouldMakeRoverFaceEast() {
        rover = new Rover(1,1,"N");
        rover.turnRight();
        assertTrue(rover.getOrientation() instanceof EastState);
    }

    @Test
    public void whenFacingWestTurningLeftShouldMakeRoverFaceSouth() {
        rover = new Rover(1,1,"W");
        rover.turnLeft();
        assertTrue(rover.getOrientation() instanceof SouthState);
    }

    @Test
    public void whenFacingWestTurningRightShouldMakeRoverFaceNorth() {
        rover = new Rover(1,1,"W");
        rover.turnRight();
        assertTrue(rover.getOrientation() instanceof NorthState);
    }

    @Test
    public void whenFacingSouthTurningLeftShouldMakeRoverFaceEast() {
        rover = new Rover(1,1,"S");
        rover.turnLeft();
        assertTrue(rover.getOrientation() instanceof EastState);
    }

    @Test
    public void whenFacingSouthTurningRightShouldMakeRoverFaceWest() {
        rover = new Rover(1,1,"S");
        rover.turnRight();
        assertTrue(rover.getOrientation() instanceof WestState);
    }

    @Test
    public void whenFacingEastTurningLeftShouldMakeRoverFaceNorth() {
        rover = new Rover(1,1,"E");
        rover.turnLeft();
        assertTrue(rover.getOrientation() instanceof NorthState);
    }

    @Test
    public void whenFacingEastTurhingRightShouldMakeRoverFaceSouth() {
        rover = new Rover(1,1,"E");
        rover.turnRight();
        assertTrue(rover.getOrientation() instanceof SouthState);
    }
}
