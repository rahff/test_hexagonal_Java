package com.ardevelopment.tweetos.core.valueObjects;



import com.ardevelopment.tweetos.core.exceptions.NotStrongPasswordException;

import java.util.regex.Pattern;

public class Password {

    private String value;

    public Password(String password){
        if(!isStrongPassword(password)) throw new NotStrongPasswordException();
        this.value = password;
    }

    private boolean isStrongPassword(String value) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
        return pattern.matcher(value).matches();
    }

    public String getValue() {
        return value;
    }
}
