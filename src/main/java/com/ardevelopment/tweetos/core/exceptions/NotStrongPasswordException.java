package com.ardevelopment.tweetos.core.exceptions;

public class NotStrongPasswordException extends RuntimeException {
    public NotStrongPasswordException(){
        super("Password must be strong");
    }
}
