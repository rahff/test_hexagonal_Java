package com.ardevelopment.tweetos.core.exceptions;

public class TweetosNotFoundException extends RuntimeException {

    public TweetosNotFoundException(){
        super("Tweetos not found");
    }
}
