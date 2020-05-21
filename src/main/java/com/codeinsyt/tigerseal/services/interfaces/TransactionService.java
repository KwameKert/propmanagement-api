package com.codeinsyt.tigerseal.services.interfaces;

import com.codeinsyt.tigerseal.DTO.TransactionDTO;

import java.util.HashMap;

public interface TransactionService {


    public HashMap<String, Object> createTransaction(TransactionDTO transactionDTO);

    public HashMap<String, Object> listAllTransactions();

    public HashMap<String, Object> listUserTransaction();



}
