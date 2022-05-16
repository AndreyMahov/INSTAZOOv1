package com.example.instazoo_v1.payLoad.request;

import com.example.instazoo_v1.annotations.PasswordMatches;
import com.example.instazoo_v1.annotations.ValidEmail;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Data
@PasswordMatches
public class SignupRequest {
@Email(message = "It should have email's format")
@NotBlank(message = "User email is required ")
@ValidEmail
    private String email;
    @NotEmpty(message = "Please enter your firstname")
    private String firstname;
    @NotEmpty(message = "Please enter your lastname")
    private String lastname;
    @NotEmpty(message = "Please enter your username")
    private String username;
    @NotEmpty(message = "Please enter your password")
    @Size(min = 6)
    private String password;
//    @NotEmpty (message = "Please confirm Password")
    private String confirmPassword;


}
