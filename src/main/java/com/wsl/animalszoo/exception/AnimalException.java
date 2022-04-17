package com.wsl.animalszoo.exception;

public class AnimalException extends Exception {
    private String message;

    public AnimalException(String message) {
        this.message = message;
    }
}
