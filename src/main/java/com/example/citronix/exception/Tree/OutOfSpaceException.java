package com.example.citronix.exception.Tree;

public class OutOfSpaceException extends RuntimeException {
    public OutOfSpaceException(String message) {
        super(message);
    }
}
