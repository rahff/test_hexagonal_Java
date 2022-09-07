package com.ardevelopment.tweetos.core.valueObjects;


import com.ardevelopment.tweetos.core.exceptions.TweetContentException;

public class CommentContent {

    private String value;

    public CommentContent(String value) {
        if(value.isBlank()) throw new TweetContentException();
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
