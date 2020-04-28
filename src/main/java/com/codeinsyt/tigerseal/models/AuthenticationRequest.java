package com.codeinsyt.tigerseal.models;

//import com.codeinsyt.tigerseal.utils.EncryptPassword;

public class AuthenticationRequest {

    private String username;
    private String password;



    public AuthenticationRequest() {
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

    public void setPassword(String password)  {

        this.password = password;
       // this.password = EncryptPassword.hashPassword(password);
    }

    @Override
    public String toString() {
        return "AuthenticationRequest{" +
                "userName='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }




}
