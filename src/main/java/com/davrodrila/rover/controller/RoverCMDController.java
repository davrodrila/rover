package com.davrodrila.rover.controller;

import com.davrodrila.rover.Plateau;

/**
 * Created by David on 28/08/2015.
 */
public class RoverCMDController {

    private States state;
    private Plateau plateau;
    public RoverCMDController() {
        state = States.PlateauInit;
    }

    public States getState() {
        return state;
    }

    public void sendCommand(String command){
        String[] args = command.split(" ");
        plateau = new Plateau(Integer.valueOf(args[0]),Integer.valueOf(args[1]));
    }

    public int getWidth() {
        return plateau.getWidth();
    }

    public int getHeight() {
        return plateau.getHeight();
    }
}
