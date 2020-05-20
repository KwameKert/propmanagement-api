package com.codeinsyt.tigerseal.services.interfaces;

import com.codeinsyt.tigerseal.DTO.InvoiceDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;

public interface InvoiceService {


    public HashMap<String, Object> createInvoice(InvoiceDTO invoiceDTO );

    public HashMap<String, Object> updateInvoice(InvoiceDTO invoiceDTO);


    public HashMap<String, Object> listInvoices();

    public HashMap<String, Object> getPropertyInvoices(Long id);

    public HashMap<String, Object> getInvoice(Long id);

    public HashMap<String, Object> softDelete(Long id);

    public HashMap<String, Object> getMyInvoices();
}
