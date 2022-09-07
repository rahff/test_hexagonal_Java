package com.ardevelopment.tweetos.core.exceptions;

public class InvalidEmailException extends RuntimeException{

    public InvalidEmailException(){
        super("Invalid email provided");
    }
}
