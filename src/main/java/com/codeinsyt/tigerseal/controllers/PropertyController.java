package com.codeinsyt.tigerseal.controllers;

import com.codeinsyt.tigerseal.DTO.PropertyDTO;
import com.codeinsyt.tigerseal.services.interfaces.PropertyService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/property")
public class PropertyController {

    private PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }


    @PostMapping
    public ResponseEntity<?> addProperty(@Valid @RequestBody PropertyDTO propertyDTO){
        return new ResponseEntity<>(this.propertyService.createProperty(propertyDTO), HttpStatus.OK);
    }



}
