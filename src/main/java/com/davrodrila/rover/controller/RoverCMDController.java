package com.davrodrila.rover.controller;

import com.davrodrila.rover.beans.*;
import com.davrodrila.rover.exceptions.*;

/**
 * Created by David on 28/08/2015.
 */
public class RoverCMDController {

    private States state;
    private Plateau plateau;
    private Rover rover;

    private static String ERROR_MALFORMED_COMMAND = "The command provided is not correct.";
    private static String MALFORMED_PLATEAU_INIT_INSTRUCTIONS = " You should provide two positive numbers separated with a space. Eg: 5 5";
    private static String MALFORMED_ROVER_INIT_INSTRUCTIONS = " You should provide two positive numbers followed by a cardinal direction (N,S,W,E). Eg: 1 2 N";
    private static String ERROR_MSG = "There was a problem trying to execute your command.";
    private static String INVALID_POSITION_ROVER_CREATION = " Can't create rover on provided positions, the plateau is too small.";

    private static String REGEX_PLATEAU_INIT_SYNTAX = "\\d\\s\\d";
    private static String REGEX_ROVER_INIT_SYNTAX = "\\d\\s\\d\\s[NSWE]";

    private static int FIRST_ARGUMENT=0;
    private static int SECOND_ARGUMENT=1;
    private static int THIRD_ARGUMENT=2;
    public RoverCMDController() {
        state = States.PlateauInit;
        plateau = new Plateau(0,0);
        rover = new Rover(0,0,"N");
    }

    public States getState() {
        return state;
    }

    public void sendCommand(String command) throws MalformedCommandException {
        if (checkCommand(command)) {
            processCommand(command);
        }
    }

    private void processCommand(String command) {
        String[] args = command.split(" ");
        switch (state) {
            case PlateauInit:
                plateau.setWidth(Integer.parseInt(args[FIRST_ARGUMENT]));
                plateau.setHeight(Integer.parseInt(args[SECOND_ARGUMENT]));
                state = States.RoverDefinition;
                break;
            case RoverDefinition:
                //TODO: This conditional looks kinda messy.
                if (plateau.getWidth()>=Integer.parseInt(args[FIRST_ARGUMENT]) && plateau.getHeight()>=Integer.parseInt(args[SECOND_ARGUMENT])) {
                    rover.setX(Integer.parseInt(args[FIRST_ARGUMENT]));
                    rover.setY(Integer.parseInt(args[SECOND_ARGUMENT]));
                    rover.setOrientation(args[THIRD_ARGUMENT]);
                } else {
                    throw new InvalidPositionException(ERROR_MSG + INVALID_POSITION_ROVER_CREATION);
                }
                break;
            case RoverMovement:
                break;
        }
    }

    /**
     *
     * @param command
     * @return whether the command is syntactically correct. Please do note that a syntactically correct command does not mean it's a correct one, as you could ask for a Rover on coordinates 16 16 on a 5x5 Plateau.
     * @throws MalformedCommandException
     */
    private boolean checkCommand(String command) throws MalformedCommandException{
        boolean commandIsCorrect=false;
        switch (state) {
            case PlateauInit:
                if (command.matches(REGEX_PLATEAU_INIT_SYNTAX)) {
                    commandIsCorrect=true;
                } else {
                    throw new MalformedCommandException(ERROR_MALFORMED_COMMAND + MALFORMED_PLATEAU_INIT_INSTRUCTIONS);
                }
                break;
            case RoverDefinition:
                if (command.matches(REGEX_ROVER_INIT_SYNTAX)) {
                    commandIsCorrect=true;
                } else {
                    throw new MalformedCommandException(ERROR_MALFORMED_COMMAND + MALFORMED_ROVER_INIT_INSTRUCTIONS);
                }
                break;
            case RoverMovement:
                break;
        }
        return commandIsCorrect;
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
