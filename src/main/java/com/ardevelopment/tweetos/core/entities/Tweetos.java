package com.ardevelopment.tweetos.core.entities;

import com.ardevelopment.tweetos.core.ports.driver.dto.TweetosDto;
import com.ardevelopment.tweetos.core.valueObjects.Email;
import com.ardevelopment.tweetos.core.valueObjects.EntityId;
import com.ardevelopment.tweetos.core.valueObjects.Password;
import com.ardevelopment.tweetos.core.valueObjects.TweetosName;

public class Tweetos {
    private EntityId _id;
    private TweetosName username;
    private Password password;

    private Email email;

    public Tweetos(EntityId _id, TweetosName username, Email email, Password password){
        this._id = _id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email.getValue();
    }

    public String getPassword() {
        return password.getValue();
    }

    public String getUsername() {
        return username.getValue();
    }

    public String get_id() {
        return _id.getValue();
    }

    public TweetosDto asDto() {
        return new TweetosDto(this.get_id(), this.getUsername(), this.getEmail());
    }
}
