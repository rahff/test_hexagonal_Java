package com.ardevelopment.tweetos.core.exceptions;

public class TweetNotFoundException extends RuntimeException{

    public TweetNotFoundException(){
        super("Tweet not found");
    }
}
