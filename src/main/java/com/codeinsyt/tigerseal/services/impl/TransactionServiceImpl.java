package com.codeinsyt.tigerseal.services.impl;

import com.codeinsyt.tigerseal.DTO.TransactionDTO;
import com.codeinsyt.tigerseal.models.Invoice;
import com.codeinsyt.tigerseal.models.Transaction;
import com.codeinsyt.tigerseal.repositories.InvoiceRepository;
import com.codeinsyt.tigerseal.repositories.TransactionRepository;
import com.codeinsyt.tigerseal.services.interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl  implements TransactionService {


    private TransactionRepository transactionRepository;
    private InvoiceRepository invoiceRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository,InvoiceRepository invoiceRepository) {
        this.transactionRepository = transactionRepository;
        this.invoiceRepository =  invoiceRepository;
    }

    public HashMap<String, Object> responseAPI(Object data, String message, HttpStatus status){
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("data",data);
        responseData.put("message",message);
        responseData.put("status", status.value());

        return responseData;
    }

    @Override
    public HashMap<String, Object> createTransaction(TransactionDTO transactionDTO) {

        try{

            Optional<Invoice> invoice = this.invoiceRepository.findById(transactionDTO.getInvoiceId());

            Transaction transaction = new Transaction();
            transaction.setAmount(transactionDTO.getAmount());
            transaction.setInvoice(invoice.get());
            transaction.setMethod(transactionDTO.getMethod());
            transaction.setUserId(transactionDTO.getUserId());

            Transaction newTransaction = this.transactionRepository.save(transaction);

            return responseAPI(newTransaction, "Transaction added successfully", HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }

    }

    public HashMap<String, Object> listAllTransactions() {

        try{

            List<Transaction> transactionList = this.transactionRepository.findAll();

            if(transactionList.isEmpty()){
                return responseAPI(null, "No Transactions found", HttpStatus.NO_CONTENT);
            }
            return responseAPI(transactionList, "Transactions found", HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> listUserTransaction() {

        try{

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            AuthDetailsImpl  authDetails = (AuthDetailsImpl) auth.getPrincipal();
            Long userId = authDetails.getUser().getId();

            List<Transaction> transactionList = this.transactionRepository.findByUserId(userId);

            if(transactionList.isEmpty()){
                return responseAPI(null, "No Transactions found", HttpStatus.NO_CONTENT);
            }
            return responseAPI(transactionList, "Transactions found", HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }


      //  return null;
    }
}
