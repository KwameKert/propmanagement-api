package com.codeinsyt.tigerseal.services.impl;

import com.codeinsyt.tigerseal.models.Invoice;
import com.codeinsyt.tigerseal.services.interfaces.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    public HashMap<String, Object> responseAPI(Object data, String message, HttpStatus status){
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("data",data);
        responseData.put("message",message);
        responseData.put("status", status.value());

        return responseData;
    }

    @Override
    public HashMap<String, Object> createInvoice(Invoice invoice) {
        return null;
    }

    @Override
    public HashMap<String, Object> updateInvoice(Invoice invoice) {
        return null;
    }

    @Override
    public HashMap<String, Object> listInvoices() {
        return null;
    }

    @Override
    public HashMap<String, Object> softDelete(Long id) {
        return null;
    }
}
