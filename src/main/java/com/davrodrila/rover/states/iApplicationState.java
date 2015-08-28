package com.davrodrila.rover.states;

import com.davrodrila.rover.beans.*;

/**
 * Created by David on 28/08/2015.
 */
public interface iApplicationState {

    public void executeCommand(String[] argsFromInput,Rover rover, Plateau plateau);

    public boolean checkCommand(String command);
}
