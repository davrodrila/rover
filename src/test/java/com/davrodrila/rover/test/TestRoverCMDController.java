package com.davrodrila.rover.test;

import com.davrodrila.rover.controller.*;
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
    public void firstCommandSentCorrectly(){
        int maxSize = 5;
        controller.sendCommand(maxSize + " " + maxSize);
        assertTrue(controller.getWidth()==maxSize);
        assertTrue(controller.getHeight()==maxSize);
    }


}
