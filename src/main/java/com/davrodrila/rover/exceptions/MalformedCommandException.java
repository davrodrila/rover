package com.davrodrila.rover.exceptions;

/**
 * Created by David on 28/08/2015.
 */

/*
 * Please note, for testing and refactoring convenience this is done as a RuntimeException.
 * In case a checked exception is required, this should extend Exception instead, and refactor the Tests accordingly.
 *
 */
public class MalformedCommandException extends RuntimeException {

    public MalformedCommandException(){}

    public MalformedCommandException(String message) {
        super(message);
    }
}
