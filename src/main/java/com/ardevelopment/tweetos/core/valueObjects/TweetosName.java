package com.ardevelopment.tweetos.core.valueObjects;

public class TweetosName {

    private String value;

    public TweetosName(String lastname, String firstname){
        this.value = lastname + " " + firstname;
    }

    public String getValue() {
        return value;
    }
}
