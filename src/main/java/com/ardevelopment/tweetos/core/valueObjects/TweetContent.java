package com.ardevelopment.tweetos.core.valueObjects;


import com.ardevelopment.tweetos.core.exceptions.TweetContentException;

public class TweetContent {

    private String textValue;

    public TweetContent(String textValue) {
        if(textValue.length() < 4 || textValue.length() > 255) throw new TweetContentException();
        this.textValue = textValue;
    }

    public String getTextValue() {
        return textValue;
    }
}
