package com.example.citronix.exception.Farm;

public class FarmAlreadyExistedException extends RuntimeException {
  public FarmAlreadyExistedException(String message) {
    super(message);
  }
}
