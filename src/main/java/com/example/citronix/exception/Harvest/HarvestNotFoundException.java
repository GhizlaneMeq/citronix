package com.example.citronix.exception.Harvest;

public class HarvestNotFoundException extends RuntimeException {
    public HarvestNotFoundException(String message) {
        super(message);
    }
}
