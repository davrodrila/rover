package com.davrodrila.rover.controller;

import com.davrodrila.rover.beans.*;
import com.davrodrila.rover.exceptions.*;
import com.davrodrila.rover.states.*;

/**
 * Created by David on 28/08/2015.
 */
public class RoverController {

    private iApplicationState state;
    private Plateau plateau;
    private Rover rover;

    private static String SEPARATOR_CHARACTER = " ";
    private static String DEFAULT_ROVER_ORIENTATION = "N";

    public RoverController() {
        state = new PlateauInitState();
        plateau = new Plateau(0,0);
        rover = new Rover(new Coordinates(0,0),DEFAULT_ROVER_ORIENTATION);
    }


    public iApplicationState getState() {
        return state;
    }

    public void sendCommand(String command) throws MalformedCommandException,InvalidPositionException {
        command = command.toUpperCase();
        if (state.checkCommand(command)) {
            state = state.executeCommand(command.split(SEPARATOR_CHARACTER),rover,plateau);
        }
    }

    public void showMessage() {
        System.out.println(state.getPrompt());
    }
}
