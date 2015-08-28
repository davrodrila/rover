package com.davrodrila.rover.states;

import com.davrodrila.rover.beans.*;
import com.davrodrila.rover.exceptions.*;

/**
 * Created by David on 28/08/2015.
 */
public class RoverMovementState implements iApplicationState {

    public static String REGEX_ROVER_MOVEMENT = "[LRM]+";
    public static String MALFORMED_MOVEMENT_INSTRUCTIONS = "You have to use either L or R to indicate the rover where tu turn, and M to advance. Do not use spaces to separate orders.";
    public static String INVALID_POSITION_ROVER_MOVEMENT = "Your route ends up in some invalid coordinates on the plateau at some point.";

    private static int FIRST_ARGUMENT = 0;
    @Override
    public iApplicationState executeCommand(String[] argsFromInput, Rover rover, Plateau plateau) {
        String command = argsFromInput[FIRST_ARGUMENT];
        for (int i=0;i<command.length();i++) {
            if (command.charAt(i)=='L') {
                rover.turnLeft();
            } else if (command.charAt(i)=='R') {
                rover.turnRight();
            } else if (command.charAt(i)=='M') {
                if (plateau.areThisCoordinatesValid(rover.simulateMovement())) {
                    rover.move();
                } else
                    throw new InvalidPositionException(INVALID_POSITION_ROVER_MOVEMENT);
            }
        }
        return new RoverInitializationState();
    }

    @Override
    public boolean checkCommand(String command) {
        if (command.matches(REGEX_ROVER_MOVEMENT)) {
            return true;
        } else {
            throw new MalformedCommandException(MALFORMED_MOVEMENT_INSTRUCTIONS);
        }
    }
}
