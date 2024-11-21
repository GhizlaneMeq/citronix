package com.example.citronix.exception.Farm;

public class FarmNotFoundException extends RuntimeException {
    public FarmNotFoundException(String message) {
        super(message);
    }
}
