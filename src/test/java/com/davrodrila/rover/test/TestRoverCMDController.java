package com.davrodrila.rover.test;

import com.davrodrila.rover.controller.*;
import com.davrodrila.rover.exceptions.MalformedCommandException;
import org.junit.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by David on 28/08/2015.
 */
public class TestRoverCMDController {

    private RoverCMDController controller;


    @Before
    public void initiateController() {
        controller = new RoverCMDController();
    }

    @Test
    public void initialStateShouldBePlateauInitilization() {
        assertTrue(controller.getState() == States.PlateauInit);
    }

    @Test
    public void firstCommandSentCorrectly() {
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
}
