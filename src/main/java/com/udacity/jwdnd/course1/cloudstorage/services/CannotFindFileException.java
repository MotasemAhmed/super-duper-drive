package com.udacity.jwdnd.course1.cloudstorage.services;

public class CannotFindFileException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public CannotFindFileException(String message) {
        super(message);
    }

    public CannotFindFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
