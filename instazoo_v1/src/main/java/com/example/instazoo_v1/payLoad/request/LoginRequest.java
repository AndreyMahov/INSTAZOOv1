package com.example.instazoo_v1.payLoad.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequest {

   @NotEmpty(message = "Username cannot de empty")
    private String username;
    @NotEmpty(message = "Password cannot de empty")
    private String password;


}
