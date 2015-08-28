package com.davrodrila.rover.test;

import com.davrodrila.rover.controller.RoverCMDController;
import com.davrodrila.rover.exceptions.*;
import com.davrodrila.rover.states.*;
import org.junit.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by David on 28/08/2015.
 */
public class TestRoverCMDController {

    //TODO: The controller should be pulled into an interface and this should use a Mock object.
    private RoverCMDController controller;


    @Before
    public void initiateController() {
        controller = new RoverCMDController();
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
        assertTrue(controller.getRover().getX()==1 && controller.getRover().getY()==2 && controller.getRover().getOrientation().equals("N"));

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
}
