package com.codeinsyt.tigerseal.controllers;


import com.codeinsyt.tigerseal.models.User;
import com.codeinsyt.tigerseal.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user/")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<?> addUser(@Valid @RequestBody User user){
        System.out.println(user);
        return new ResponseEntity<>(this.userService.createUser(user), HttpStatus.OK);
    }
}
