package com.codeinsyt.tigerseal.controllers;

import com.codeinsyt.tigerseal.DTO.PropertyDTO;
import com.codeinsyt.tigerseal.DTO.TransactionDTO;
import com.codeinsyt.tigerseal.services.interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/transaction/")
public class TransactionController {


    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<?> addTransaction(@Valid @RequestBody TransactionDTO transactionDTO){
        return new ResponseEntity<>(this.transactionService.createTransaction(transactionDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listTransaction(){
        return new ResponseEntity<>(this.transactionService.listAllTransactions(), HttpStatus.OK);
    }



}
