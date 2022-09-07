package com.ardevelopment.tweetos.core.exceptions;

public class EmailAlreadyExistException extends RuntimeException {

    public EmailAlreadyExistException(){
        super("Email already exist");
    }
}
