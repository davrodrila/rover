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
    private static int FIRST_ARGUMENT = 0;
    private static int SECOND_ARGUMENT = 1;
    private static int THIRD_ARGUMENT = 2;

    @Override
    public iApplicationState executeCommand(String[] argsFromInput, Rover rover, Plateau plateau) {
        if (plateau.getWidth()>=Integer.parseInt(argsFromInput[FIRST_ARGUMENT]) && plateau.getHeight()>=Integer.parseInt(argsFromInput[SECOND_ARGUMENT])) {
            rover.setX(Integer.parseInt(argsFromInput[FIRST_ARGUMENT]));
            rover.setY(Integer.parseInt(argsFromInput[SECOND_ARGUMENT]));
            rover.setOrientation(argsFromInput[THIRD_ARGUMENT]);
        } else {
            throw new InvalidPositionException(INVALID_POSITION_ROVER_CREATION);
        }
        return new RoverMovementState();
    }

    @Override
    public boolean checkCommand(String command) {
        if (!command.matches(REGEX_ROVER_INIT_SYNTAX)) {
            throw new MalformedCommandException();
        } else {
            return true;
        }
    }
}
