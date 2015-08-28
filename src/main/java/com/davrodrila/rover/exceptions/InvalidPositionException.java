package com.davrodrila.rover.exceptions;

/**
 * Created by David on 28/08/2015.
 */
public class InvalidPositionException extends RuntimeException {

    public InvalidPositionException(){}

    public InvalidPositionException(String message) {
        super(message);
    }
}
