package com.davrodrila.rover.exceptions;

/**
 * Created by David on 28/08/2015.
 */
public class InvalidPositionException extends RuntimeException {
    private static String ERROR_MSG = "There was a problem trying to execute your command. ";

    public InvalidPositionException(){}

    public InvalidPositionException(String message) {
        super(ERROR_MSG + message);
    }
}
