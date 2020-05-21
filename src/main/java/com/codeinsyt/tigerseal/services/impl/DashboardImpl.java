package com.codeinsyt.tigerseal.services.impl;

import com.codeinsyt.tigerseal.models.Transaction;
import com.codeinsyt.tigerseal.models.User;
import com.codeinsyt.tigerseal.repositories.InvoiceRepository;
import com.codeinsyt.tigerseal.repositories.PropertyRepository;
import com.codeinsyt.tigerseal.repositories.TransactionRepository;
import com.codeinsyt.tigerseal.repositories.UserRepository;
import com.codeinsyt.tigerseal.services.interfaces.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DashboardImpl implements DashboardService {

    private UserRepository userRepository;
    private InvoiceRepository invoiceRepository;
    private TransactionRepository transactionRepository;
    private PropertyRepository propertyRepository;

    @Autowired
    public DashboardImpl(UserRepository userRepository, InvoiceRepository invoiceRepository, TransactionRepository transactionRepository, PropertyRepository propertyRepository) {
        this.userRepository = userRepository;
        this.invoiceRepository = invoiceRepository;
        this.transactionRepository = transactionRepository;
        this.propertyRepository = propertyRepository;
    }

    public HashMap<String, Object> responseAPI(Object data, String message, HttpStatus status){
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("data",data);
        responseData.put("message",message);
        responseData.put("status", status.value());

        return responseData;
    }


    @Override
    public HashMap<String, Object> adminDashboard() {
        try{

           int userCount = this.userRepository.findAll().size();
           int propertyCount = this.propertyRepository.findAllByStatNotOrderByIdAsc("deleted").size();
           int transactionCount = this.transactionRepository.findAll().size();
           double revenue = this.transactionRepository.sumAmount();
           List<?> monthlyTransaction = this.transactionRepository.monthlyTransaction();

           HashMap<String, Object> response = new HashMap<>();
           response.put("user", userCount);
           response.put("property", propertyCount);
           response.put("transaction", transactionCount);
           response.put("revenue", revenue);
           response.put("month", monthlyTransaction);

           return responseAPI(response,"Dashboard components",HttpStatus.OK );

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> collectorDashboard() {
        return null;
    }

    @Override
    public HashMap<String, Object> auditorDashboard() {
        return null;
    }
}
