package com.codeinsyt.tigerseal.controllers;

import com.codeinsyt.tigerseal.DTO.InvoiceDTO;
import com.codeinsyt.tigerseal.services.interfaces.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/invoice/")
public class InvoiceController  {

    private InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }


    @PostMapping
    public ResponseEntity<?> addInvoice(@Valid @RequestBody InvoiceDTO invoiceDTO ){
        return new ResponseEntity<>(this.invoiceService.createInvoice(invoiceDTO), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<?> updateInvoice(@Valid @RequestBody InvoiceDTO invoiceDTO){
        return new ResponseEntity<>(this.invoiceService.updateInvoice(invoiceDTO), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<?> listInvoice(){
        return new ResponseEntity<>(this.invoiceService.listInvoices(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getInvoice(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.invoiceService.getInvoice(id), HttpStatus.OK);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteInvoice(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.invoiceService.softDelete(id), HttpStatus.OK);
    }

}
