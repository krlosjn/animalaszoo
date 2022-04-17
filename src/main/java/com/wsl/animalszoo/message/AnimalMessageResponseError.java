package com.wsl.animalszoo.message;

public class AnimalMessageResponseError extends  AnimalMessageResponse{
    private String messageError;
    public AnimalMessageResponseError(String messageError) {
        this.messageError = messageError;
    }
}
