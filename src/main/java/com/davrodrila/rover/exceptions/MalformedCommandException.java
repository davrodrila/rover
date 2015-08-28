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
    private static String ERROR_MALFORMED_COMMAND = "The command provided is not correct. ";

    public MalformedCommandException(){}

    public MalformedCommandException(String message) {
        super(ERROR_MALFORMED_COMMAND + message);
    }
}
