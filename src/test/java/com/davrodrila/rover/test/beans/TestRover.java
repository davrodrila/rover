package com.davrodrila.rover.test.beans;

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
    public void givenSetOfCoordinatesCorrectlyAggregateTheMovementWhileFacingEast() {
        Coordinates expectedCoordinates = new Coordinates(2,1);
        rover = new Rover(coordinates,"E");
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
    public void givenSetOfCoordinatesCorrectlyAggregateTheMovementWhileFacingNorth() {
        Coordinates expectedCoordinates = new Coordinates(1,2);
        rover = new Rover(coordinates,"N");
        assertTrue(rover.simulateMovement().equals(expectedCoordinates));
    }

}
