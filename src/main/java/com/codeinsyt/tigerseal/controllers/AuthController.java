package com.codeinsyt.tigerseal.controllers;

import com.codeinsyt.tigerseal.models.AuthenticationRequest;
import com.codeinsyt.tigerseal.services.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class AuthController {

    @Autowired
    private AuthServiceImpl authService;


    @PostMapping("login")
    public ResponseEntity<?> testUser(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        System.out.println(authenticationRequest);
        return new ResponseEntity<>(this.authService.loginUser(authenticationRequest.getUsername(),authenticationRequest.getPassword()), HttpStatus.OK);

    }

    @GetMapping("hello")
    public String hello(){
        return "Hello world";
    }


    @Secured("ROLE_ADMIN")
    @GetMapping("admin/message")
    public String admin(){
        return "Im admin";
    }

    @Secured("ROLE_USER")
    @GetMapping("user")
    public String user(){
        return "Im user";
    }

}
