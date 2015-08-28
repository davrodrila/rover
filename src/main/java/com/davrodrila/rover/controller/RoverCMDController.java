package com.davrodrila.rover.controller;

import com.davrodrila.rover.beans.*;
import com.davrodrila.rover.exceptions.*;
import com.davrodrila.rover.states.*;

/**
 * Created by David on 28/08/2015.
 */
public class RoverCMDController {

    private iApplicationState state;
    private Plateau plateau;
    private Rover rover;

    private static String ERROR_MALFORMED_COMMAND = "The command provided is not correct.";
    private static String SEPARATOR_CHARACTER = " ";
    private static String DEFAULT_ROVER_ORIENTATION = "N";

    public RoverCMDController() {
        state = new PlateauInitState();
        plateau = new Plateau(0,0);
        rover = new Rover(0,0,DEFAULT_ROVER_ORIENTATION);
    }

    public iApplicationState getState() {
        return state;
    }

    public void sendCommand(String command) throws MalformedCommandException,InvalidPositionException {
        if (state.checkCommand(command)) {
            state.executeCommand(command.split(SEPARATOR_CHARACTER),rover,plateau);
            nextStep();
        }

    }


    private void nextStep() {
        if (state instanceof RoverInitializationState)
            state = new RoverMovementState();
        else
            state = new RoverInitializationState();
    }

    public int getWidth() {
        return plateau.getWidth();
    }

    public int getHeight() {
        return plateau.getHeight();
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }
}
