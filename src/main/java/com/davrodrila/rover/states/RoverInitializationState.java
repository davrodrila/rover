package com.davrodrila.rover.states;

import com.davrodrila.rover.beans.*;
import com.davrodrila.rover.exceptions.*;

/**
 * Created by David on 28/08/2015.
 */
public class RoverInitializationState implements iApplicationState {

    private static String REGEX_ROVER_INIT_SYNTAX = "\\d\\s\\d\\s[NSWE]";
    private static String MALFORMED_ROVER_INIT_INSTRUCTIONS = " You should provide two positive numbers followed by a cardinal direction (N,S,W,E). Eg: 1 2 N";
    private static String INVALID_POSITION_ROVER_CREATION = " Can't create rover on provided positions, the plateau is too small.";
    private static String PROMPT = "Insert the coordinates where the rover should start and a cardinal orientation (N,S,W,E). Eg: 1 2 N";

    private static int X_COORDINATE_ARGUMENT = 0;
    private static int Y_COORDINATE_ARGUMENT = 1;
    private static int ROVER_ORIENTATION_ARGUMENT = 2;

    @Override
    public iApplicationState executeCommand(String[] argsFromInput, Rover rover, Plateau plateau) {
        Coordinates inputCoordinates = new Coordinates(Integer.parseInt(argsFromInput[X_COORDINATE_ARGUMENT]),Integer.parseInt(argsFromInput[Y_COORDINATE_ARGUMENT]));
        if (plateau.areThisCoordinatesValid(inputCoordinates)) {
            rover.setCoordinates(inputCoordinates);
            rover.setOrientation(argsFromInput[ROVER_ORIENTATION_ARGUMENT]);
        } else {
            throw new InvalidPositionException(INVALID_POSITION_ROVER_CREATION);
        }
        return new RoverMovementState();
    }

    @Override
    public boolean checkCommand(String command) {
        command = command.toUpperCase();
        if (!command.matches(REGEX_ROVER_INIT_SYNTAX)) {
            throw new MalformedCommandException(MALFORMED_ROVER_INIT_INSTRUCTIONS);
        } else {
            return true;
        }
    }

    @Override
    public String getPrompt() {
        return PROMPT;
    }
}
