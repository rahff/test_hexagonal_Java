package com.ardevelopment.tweetos.infrastructure.dto;

import java.io.Serializable;

public class CreateTweetosRequestBody implements Serializable {
    public String lastname;
    public String firstname;
    public String email;
    public String password;

    public CreateTweetosRequestBody(){}
    public CreateTweetosRequestBody(String lastname, String firstname, String email, String password){
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
    }
}
