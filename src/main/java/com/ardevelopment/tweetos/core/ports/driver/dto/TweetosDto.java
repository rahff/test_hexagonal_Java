package com.ardevelopment.tweetos.core.ports.driver.dto;

public class TweetosDto {
    private String _id;
    private String username;
    private String email;

    public TweetosDto(String _id, String username, String email){
        this._id = _id;
        this.email = email;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String get_id() {
        return _id;
    }
}
