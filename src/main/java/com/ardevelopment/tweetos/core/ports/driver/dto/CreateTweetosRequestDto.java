package com.ardevelopment.tweetos.core.ports.driver.dto;



public class CreateTweetosRequestDto {
    private String lastname;
    private String firstname;
    private String password;
    private String email;

    public CreateTweetosRequestDto(String lastname, String firstname, String password, String email){
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
