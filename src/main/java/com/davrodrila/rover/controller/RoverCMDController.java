package com.davrodrila.rover.controller;

import com.davrodrila.rover.Plateau;
import com.davrodrila.rover.exceptions.MalformedCommandException;

/**
 * Created by David on 28/08/2015.
 */
public class RoverCMDController {

    private States state;
    private Plateau plateau;

    private static String ERROR_MALFORMED_COMMAND = "The command provided is not correct.";
    private static String MALFORMED_PLATEAU_INIT_INSTRUCTIONS = " You should provide two positive numbers separated with a space. Eg: 5 5";
    private static String REGEX_PLATEAU_INIT_SYNTAX = "\\d\\s\\d";

    public RoverCMDController() {
        state = States.PlateauInit;
        plateau = new Plateau(0,0);
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
        switch (state) {
            case PlateauInit:
                String[] args = command.split(" ");
                plateau.setWidth(Integer.parseInt(args[0]));
                plateau.setHeight(Integer.parseInt(args[1]));
            case RoverDefinition:
                break;
            case RoverMovement:
                break;
        }
    }


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
}
