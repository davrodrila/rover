package com.davrodrila.rover;

import com.davrodrila.rover.controller.RoverController;
import com.davrodrila.rover.exceptions.*;

import java.io.*;

/**
 * Created by David on 28/08/2015.
 */
public class Program {


    public static void main(String[] args) throws IOException {

        RoverController roverController = new RoverController();
        while (true) {
            try {
                roverController.showMessage();
                BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));
                roverController.sendCommand(keyboardReader.readLine());
            } catch (InvalidPositionException | MalformedCommandException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
