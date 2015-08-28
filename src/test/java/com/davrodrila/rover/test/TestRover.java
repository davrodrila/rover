package com.davrodrila.rover.test;

import com.davrodrila.rover.beans.*;
import org.junit.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by David on 28/08/2015.
 */
public class TestRover {

    Rover rover;
    Coordinates coordinates;

    @Before
    public void setupCoordinates() {
        coordinates = new Coordinates(1,1);
    }

    @Test
    public void whenCreatingAnObjectWithTheNStringNorthStateShouldBeCreated() {
        rover = new Rover(coordinates,"N");
        assertTrue(rover.getOrientation().equals("N"));
    }

    @Test
    public void whenCreatingAnObjectWithTheSStringSouthStateShouldBeCreated() {
        rover = new Rover(coordinates,"S");
        assertTrue(rover.getOrientation().equals("S"));
    }

    @Test
    public void whenCreatingAnObjectWithTheEStringEastStateShouldBeCreated() {
        rover = new Rover(coordinates,"E");
        assertTrue(rover.getOrientation().equals("E"));
    }

    @Test
    public void whenCreatingAnObjectWiththeWStringWeastStateShouldBeCreated() {
        rover = new Rover(coordinates,"W");
        assertTrue(rover.getOrientation().equals("W"));
    }

    @Test
    public void whenFacingNorthTurningLeftShouldMakeRoverFaceWest() {
        rover = new Rover(coordinates,"N");
        rover.turnLeft();
        assertTrue(rover.getOrientation().equals("W"));
    }

    @Test
    public void whenFacingNorthTurningRightShouldMakeRoverFaceEast() {
        rover = new Rover(coordinates,"N");
        rover.turnRight();
        assertTrue(rover.getOrientation().equals("E"));
    }

    @Test
    public void whenFacingWestTurningLeftShouldMakeRoverFaceSouth() {
        rover = new Rover(coordinates,"W");
        rover.turnLeft();
        assertTrue(rover.getOrientation().equals("S"));
    }

    @Test
    public void whenFacingWestTurningRightShouldMakeRoverFaceNorth() {
        rover = new Rover(coordinates,"W");
        rover.turnRight();
        assertTrue(rover.getOrientation().equals("N"));
    }

    @Test
    public void whenFacingSouthTurningLeftShouldMakeRoverFaceEast() {
        rover = new Rover(coordinates,"S");
        rover.turnLeft();
        assertTrue(rover.getOrientation().equals("E"));
    }

    @Test
    public void whenFacingSouthTurningRightShouldMakeRoverFaceWest() {
        rover = new Rover(coordinates,"S");
        rover.turnRight();
        assertTrue(rover.getOrientation().equals("W"));
    }

    @Test
    public void whenFacingEastTurningLeftShouldMakeRoverFaceNorth() {
        rover = new Rover(coordinates,"E");
        rover.turnLeft();
        assertTrue(rover.getOrientation().equals("N"));
    }

    @Test
    public void whenFacingEastTurningRightShouldMakeRoverFaceSouth() {
        rover = new Rover(coordinates,"E");
        rover.turnRight();
        assertTrue(rover.getOrientation().equals("S"));
    }

    @Test
    public void givenSetOfCoordinatesCorrectlyAggregateTheMovementWhileFacingNorth() {
        Coordinates expectedCoordinates = new Coordinates(1,2);
        rover = new Rover(coordinates,"N");
        assertTrue(rover.simulateMovement().equals(expectedCoordinates));
    }

    @Test
    public void givenSetOfCoordinatesCorrectlyAggregateTheMovementWhileFacingSouth() {
        Coordinates expectedCoordinates = new Coordinates(1,0);
        rover = new Rover(coordinates,"S");
        assertTrue(rover.simulateMovement().equals(expectedCoordinates));
    }

    @Test
    public void givenSetOfCoordinatesCorrectlyAggregateTheMovementWhileFacingWest() {
        Coordinates expectedCoordinates = new Coordinates(0,1);
        rover = new Rover(coordinates,"W");
        assertTrue(rover.simulateMovement().equals(expectedCoordinates));
    }

    @Test
    public void givenSetOfCoordinatesCorrectlyAggregateTheMovementWhileFacingEast() {
        Coordinates expectedCoordinates = new Coordinates(2,1);
        rover = new Rover(coordinates,"E");
        assertTrue(rover.simulateMovement().equals(expectedCoordinates));
    }
}
