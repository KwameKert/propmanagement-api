package com.codeinsyt.tigerseal.controllers;

import com.codeinsyt.tigerseal.models.AuthenticationRequest;
import com.codeinsyt.tigerseal.services.impl.UserServiceImpl;
import com.codeinsyt.tigerseal.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class AuthController {

    @Autowired
    private UserServiceImpl userService;


    @PostMapping("login")
    public ResponseEntity<?> testUser(@RequestBody AuthenticationRequest authenticationRequest){

        String response = "hello";
        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUserName(),authenticationRequest.getPassword());
        System.out.println(userDetails);

        return new ResponseEntity<>(userDetails, HttpStatus.OK);

    }


}
