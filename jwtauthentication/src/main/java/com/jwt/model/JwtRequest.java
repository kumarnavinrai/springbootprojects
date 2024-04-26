package com.jwt.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class JwtRequest {

    @NotEmpty(message = "Username cannot be empty")
    String username;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 5, max = 20, message = "Password min length 5 max 20 characters")
    String password;

    public JwtRequest() {
    }

    public JwtRequest(String username, String password) {

        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "JwtRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
