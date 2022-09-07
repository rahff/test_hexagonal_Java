package com.ardevelopment.tweetos.core.valueObjects;

import com.ardevelopment.tweetos.core.exceptions.InvalidEmailException;
import java.util.regex.Pattern;

public class Email {

    private String value;

    public Email(String value){
        if(!this.isValidEmail(value)) throw new InvalidEmailException();
        this.value = value;
    }

    private boolean isValidEmail(String email){
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        return pattern.matcher(email).matches();
    }

    public String getValue() {
        return value;
    }
}
