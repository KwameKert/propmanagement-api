package com.codeinsyt.tigerseal.controllers;


import com.codeinsyt.tigerseal.DTO.UserDTO;
import com.codeinsyt.tigerseal.models.User;
import com.codeinsyt.tigerseal.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> addUser(@Valid @RequestBody UserDTO userDTO){
        return new ResponseEntity<>(this.userService.createUser(userDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listAllUsers(){
        return new ResponseEntity<>(this.userService.listUsers(), HttpStatus.OK);
    }

    @GetMapping("owners")
    public ResponseEntity<?> listAllOwners(){
        return new ResponseEntity<>(this.userService.listOwners(), HttpStatus.OK);
    }

    @GetMapping("collectors")
    public ResponseEntity<?> listAllCollector(){
        return new ResponseEntity<>(this.userService.listCollectors(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> viewUser(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.userService.getUser(id), HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.userService.softDelete(id), HttpStatus.OK);
    }

}
