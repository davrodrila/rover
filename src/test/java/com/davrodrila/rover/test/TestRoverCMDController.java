package com.davrodrila.rover.test;

import com.davrodrila.rover.beans.Coordinates;
import com.davrodrila.rover.controller.RoverController;
import com.davrodrila.rover.exceptions.*;
import com.davrodrila.rover.states.*;
import org.junit.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by David on 28/08/2015.
 */
public class TestRoverCMDController {

    //TODO: The controller should be pulled into an interface and this should use a Mock object.
    private RoverController controller;


    @Before
    public void initiateController() {
        controller = new RoverController();
    }

    @Test
    public void initialStateShouldBePlateauInitilization() {
        assertTrue(controller.getState() instanceof PlateauInitState);
    }

    @Test
    public void firstCommandSentProperlyFormed() {
        int maxSize = 5;
        controller.sendCommand(maxSize + " " + maxSize);
        assertTrue(controller.getWidth() == maxSize);
        assertTrue(controller.getHeight()==maxSize);
    }

    @Test
    public void callWidthHeightPropertiesBeforeSettingPlateauShouldReturnZero() {
        assertTrue(controller.getHeight()==0);
        assertTrue(controller.getWidth()==0);
    }

    @Test(expected=MalformedCommandException.class)
    public void firstCommandSentMalformed()  {
        controller.sendCommand("55");
    }

    @Test(expected=MalformedCommandException.class)
    public void firstCommandSentWithNegativeNumbers() {
        controller.sendCommand("-5 -5");
    }

    @Test
    public void stateSouldBePointingToRoverCreationAfterPlateauSetUp() {
        controller.sendCommand("5 5");
        assertTrue(controller.getState() instanceof RoverInitializationState);
    }

    @Test
    public void secondCommandSentProperlyFormed() {
        controller.sendCommand("5 5");
        controller.sendCommand("1 2 N");
    }

    @Test(expected=MalformedCommandException.class)
    public void secondCommandSentMalformed() {
        controller.sendCommand("5 5");
        controller.sendCommand("1 2N");
    }

    @Test(expected=MalformedCommandException.class)
    public void secondCommandSentWithIncorrectCardinalDirection() {
        controller.sendCommand("5 5");
        controller.sendCommand("1 2 M");
    }

    @Test
    public void roverWasSuccessfullyCreated() {
        controller.sendCommand("5 5");
        controller.sendCommand("1 2 N");
        assertTrue(controller.getRover().getCoordinates().getX()==1 && controller.getRover().getCoordinates().getY()==2 && controller.getRover().getOrientation().equals("N"));

    }

    @Test(expected = InvalidPositionException.class)
    public void roverCreatedInInvalidPosition() {
        controller.sendCommand("5 5");
        controller.sendCommand("6 5 N");
    }

    @Test
    public void stateGoesToRoverMovementAfterRoverDefinition() {
        controller.sendCommand("5 5");
        controller.sendCommand("1 2 N");
        assertTrue(controller.getState() instanceof RoverMovementState);
    }

    @Test
    public void stateShouldNotAdvanceWhenIncorrectPositionIsGiven() {
        controller.sendCommand("5 5");
        try {
            controller.sendCommand("6 5 N");
        }catch (InvalidPositionException e) {
            assertTrue(controller.getState() instanceof RoverInitializationState);
        }
    }

    @Test
    public void properMovementCommandSent(){
        controller.sendCommand("5 5");
        controller.sendCommand("1 2 N");
        controller.sendCommand("MMRM");
    }

    @Test(expected = MalformedCommandException.class)
    public void wrongMovementCommandSent() {
        controller.sendCommand("5 5");
        controller.sendCommand("1 2 N");
        controller.sendCommand("MMUM");
    }

    @Test
    public void checkIfEndCoordinatesAreCorrect() {
        Coordinates expectedCoordinates = new Coordinates(1,4);
        controller.sendCommand("5 5");
        controller.sendCommand("1 1 N");
        controller.sendCommand("MRMMLMMLMM");
        assertTrue(controller.getRover().getCoordinates().equals(expectedCoordinates));
    }

    @Test(expected = InvalidPositionException.class)
    public void shouldThrowExceptionsIfMovementGoesThroughWrongCoordinates() {
        controller.sendCommand("5 5");
        controller.sendCommand("1 1 N");
        controller.sendCommand("MMMMLMM");
    }
}
