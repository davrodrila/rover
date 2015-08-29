package com.davrodrila.rover.test.states;

import com.davrodrila.rover.beans.*;
import com.davrodrila.rover.exceptions.*;
import com.davrodrila.rover.states.RoverMovementState;
import org.junit.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by David on 29/08/2015.
 */
public class TestRoverMovementState {

    RoverMovementState state;
    Rover rover;
    Plateau plateau;

    @Before
    public void setupMovementState() {
        state = new RoverMovementState();
        rover = new Rover(new Coordinates(1,2),"N");
        plateau = new Plateau(5,5);
    }

    @Test
    public void properMovementCommandSent(){
        state.checkCommand("MMRM");
    }

    @Test(expected = MalformedCommandException.class)
    public void wrongMovementCommandSent() {
        state.checkCommand("MMYM");
    }

    @Test
    public void commandShouldWorkWithLowercaseLetters() {
        state.checkCommand("mrm");
    }

    @Test
    public void commandShouldWorkMixingLowerAndUppercaseLetters() {
        state.checkCommand("MrM");
    }

    @Test
    public void checkIfEndCoordinatesAreCorrect() {
        Coordinates expectedCoordinates = new Coordinates(1,4);
        rover = new Rover(new Coordinates(1,1),"N");
        String[] args = {"MRMMLMMLMM"};
        state.executeCommand(args,rover,plateau);
        assertTrue(rover.getCoordinates().equals(expectedCoordinates));
    }

    @Test(expected = InvalidPositionException.class)
    public void shouldThrowExceptionsIfMovementGoesThroughWrongCoordinates() {
        rover = new Rover(new Coordinates(1,1),"N");
        String[] args = {"MMMMLMM"};
        state.executeCommand(args,rover,plateau);
    }

    @Test
    public void testIfFirstCaseGivenWorks() {
        Coordinates expectedCoordinates = new Coordinates(1,3);
        String expecetedOrientation = "N";
        String[] args = {"LMLMLMLMM"};
        state.executeCommand(args,rover,plateau);
        assertTrue(rover.getCoordinates().equals(expectedCoordinates) && rover.getOrientation().equals(expecetedOrientation));
    }

    @Test
    public void testIfSecondCaseGivenWorks() {
        Coordinates expectedCoordinates = new Coordinates(5,1);
        String expecetedOrientation = "E";
        rover = new Rover(new Coordinates(3,3),"E");
        String[] args = {"MMRMMRMRRM"};
        state.executeCommand(args,rover,plateau);
        assertTrue(rover.getCoordinates().equals(expectedCoordinates) && rover.getOrientation().equals(expecetedOrientation));
    }
}
