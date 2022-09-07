package com.ardevelopment.tweetos.core.exceptions;

public class TweetContentException extends RuntimeException{

    public TweetContentException() {
        super("A tweet content must have between 3 and 255 characters");
    }
}
