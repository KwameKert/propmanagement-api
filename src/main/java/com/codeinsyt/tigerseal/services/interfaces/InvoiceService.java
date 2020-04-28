package com.codeinsyt.tigerseal.services.interfaces;

import com.codeinsyt.tigerseal.models.Invoice;
import org.springframework.stereotype.Service;

import java.util.HashMap;

public interface InvoiceService {


    public HashMap<String, Object> createInvoice(Invoice invoice );

    public HashMap<String, Object> updateInvoice(Invoice invoice);

    public HashMap<String, Object> listInvoices();

    public HashMap<String, Object> softDelete(Long id);
}
