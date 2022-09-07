package com.ardevelopment.tweetos.core.valueObjects;

import com.ardevelopment.tweetos.core.exceptions.InvalidIdException;

import java.util.regex.Pattern;

public class EntityId {

    private String value;

    public EntityId(String id){
        if(isUUID(id)) throw new InvalidIdException();
        this.value = id;
    }

    public String getValue() {
        return value;
    }

    private boolean isUUID(String value) {
        Pattern pattern = Pattern.compile("\"[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}\"");
        return pattern.matcher(value).matches();
    }
}
