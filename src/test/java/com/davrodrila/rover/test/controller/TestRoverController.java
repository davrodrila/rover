package com.davrodrila.rover.test.controller;

import com.davrodrila.rover.controller.RoverController;
import com.davrodrila.rover.exceptions.InvalidPositionException;
import com.davrodrila.rover.states.*;
import org.junit.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by David on 28/08/2015.
 */
public class TestRoverController {

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
    public void stateSouldBePointingToRoverCreationAfterPlateauSetUp() {
        controller.sendCommand("5 5");
        assertTrue(controller.getState() instanceof RoverInitializationState);
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
