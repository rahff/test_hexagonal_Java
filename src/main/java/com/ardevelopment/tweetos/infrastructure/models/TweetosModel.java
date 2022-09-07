package com.ardevelopment.tweetos.infrastructure.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TweetosModel {

    @Id
    public String _id;
    public String email;
    public String username;
    private String password;

    public TweetosModel(String _id, String email, String username, String password){
        super();
        this._id = _id;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
