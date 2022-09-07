package com.ardevelopment.tweetos.infrastructure.exceptions;

public class SaveEntityFailedException extends RuntimeException {
    public SaveEntityFailedException(){
        super("An error was occurs during save");
    }
}
