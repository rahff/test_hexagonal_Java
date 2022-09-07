package com.ardevelopment.tweetos.core.exceptions;

public class InvalidIdException extends RuntimeException{

    public  InvalidIdException(){
        super("Id must be 12 or 24 hexadecimal value");
    }
}
