package com.davrodrila.rover.states;

import com.davrodrila.rover.beans.*;

/**
 * Created by David on 28/08/2015.
 */
public class RoverMovementState implements iApplicationState {

    @Override
    public iApplicationState executeCommand(String[] argsFromInput, Rover rover, Plateau plateau) {

        return new RoverInitializationState();
    }

    @Override
    public boolean checkCommand(String command) {
        return false;
    }
}
