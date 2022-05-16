package com.example.instazoo_v1.payLoad.response;

public class InvalidLoginResponse {
    private String name;
    private String password;

    public InvalidLoginResponse() {

        this.name = "Invalid username";
        this.password = "Invalid password";
    }
}
