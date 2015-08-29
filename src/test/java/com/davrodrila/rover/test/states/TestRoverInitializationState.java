package com.davrodrila.rover.test.states;

import com.davrodrila.rover.beans.*;
import com.davrodrila.rover.exceptions.*;
import com.davrodrila.rover.states.RoverInitializationState;
import org.junit.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by David on 29/08/2015.
 */
public class TestRoverInitializationState {

    RoverInitializationState state;
    Plateau plateau;
    Rover rover;

    @Before
    public void setUpInitializationState (){
        state = new RoverInitializationState();
        plateau = new Plateau(5,5);
        rover = new Rover(new Coordinates(1,2),"N");
    }

    @Test
    public void secondCommandSentProperlyFormed() {
        state.checkCommand("1 2 N");
    }

    @Test(expected=MalformedCommandException.class)
    public void secondCommandSentMalformed() {
        state.checkCommand("12 N");
    }

    @Test(expected=MalformedCommandException.class)
    public void secondCommandSentWithIncorrectCardinalDirection() {
        state.checkCommand("1 2 M");
    }

    @Test
    public void secondCommandWithLowercaseCardinalDirectionShouldStillWork() {
        state.checkCommand("1 2 n");
        assertTrue(rover.getOrientation().equals("N"));
    }

    @Test
    public void roverWasSuccessfullyCreated() {
        String[] args = {"1","2","N"};
        state.executeCommand(args,rover,plateau);
        assertTrue(rover.getCoordinates().getX()==1 && rover.getCoordinates().getY()==2 && rover.getOrientation().equals("N"));
    }

    @Test(expected = InvalidPositionException.class)
    public void roverCreatedInInvalidPosition() {
        String[] args = {"6", "5","N"};
        state.executeCommand(args,rover,plateau);
    }
}
