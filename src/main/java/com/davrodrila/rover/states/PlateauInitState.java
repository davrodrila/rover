package com.davrodrila.rover.states;

import com.davrodrila.rover.beans.*;
import com.davrodrila.rover.exceptions.MalformedCommandException;

/**
 * Created by David on 28/08/2015.
 */
public class PlateauInitState implements iApplicationState {

    private static String REGEX_PLATEAU_INIT_SYNTAX = "\\d\\s\\d";
    private static String MALFORMED_PLATEAU_INIT_INSTRUCTIONS = " You should provide two positive numbers separated with a space. Eg: 5 5";
    private static String PROMPT = "Insert the size of the plateau by indicating two positive numbers separated by withespace. Eg: 5 5";
    private static int WIDTH_ARGUMENT = 0;
    private static int HEIGHT_ARGUMENT = 1;

    @Override
    public iApplicationState executeCommand(String[] argsFromInput, Rover rover, Plateau plateau) {
        plateau.setWidth(Integer.parseInt(argsFromInput[WIDTH_ARGUMENT]));
        plateau.setHeight(Integer.parseInt(argsFromInput[HEIGHT_ARGUMENT]));
        return new RoverInitializationState();
    }

    @Override
    public boolean checkCommand(String command) {
        if (!command.matches(REGEX_PLATEAU_INIT_SYNTAX)) {
            throw new MalformedCommandException(MALFORMED_PLATEAU_INIT_INSTRUCTIONS);
        } else {
            return true;
        }
    }

    @Override
    public String getPrompt() {
        return PROMPT;
    }
}
