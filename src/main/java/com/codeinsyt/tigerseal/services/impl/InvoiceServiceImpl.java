package com.codeinsyt.tigerseal.services.impl;

import com.codeinsyt.tigerseal.DTO.InvoiceDTO;
import com.codeinsyt.tigerseal.models.Invoice;
import com.codeinsyt.tigerseal.models.Property;
import com.codeinsyt.tigerseal.repositories.InvoiceRepository;
import com.codeinsyt.tigerseal.repositories.PropertyRepository;
import com.codeinsyt.tigerseal.services.interfaces.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private PropertyRepository propertyRepository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, PropertyRepository propertyRepository) {
        this.invoiceRepository = invoiceRepository;
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
    public HashMap<String, Object> createInvoice(InvoiceDTO invoiceDTO) {

        try{

            Invoice invoice = new Invoice();
            invoice.setId(invoiceDTO.getId());
            invoice.setInvoiceId(invoiceDTO.getInvoiceId());
            invoice.setNotes(invoiceDTO.getNotes());
            invoice.setAmount(invoiceDTO.getAmount());
            invoice.setNotes(invoiceDTO.getNotes());
            invoice.setBillDate(invoiceDTO.getBillDate());
            invoice.setDateDue(invoiceDTO.getBillDate());
            invoice.setProperty(this.propertyRepository.findById(invoiceDTO.getPropertyId()).get());
            invoice.setStat(invoiceDTO.getStat());
            Invoice newInvoice = this.invoiceRepository.save(invoice);

            return responseAPI(newInvoice, "Invoice generated ", HttpStatus.OK);


        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }

    }


    public Invoice isInvoice(Long id){
        try{
            Invoice invoice =  this.invoiceRepository.findById(id).get();

            return invoice;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public HashMap<String, Object> updateInvoice(InvoiceDTO invoiceDTO) {

        try{

            if(isInvoice(invoiceDTO.getId()) != null){

                Invoice invoice = new Invoice();
                invoice.setId(invoiceDTO.getId());
                invoice.setInvoiceId(invoiceDTO.getInvoiceId());
                invoice.setNotes(invoiceDTO.getNotes());
                invoice.setAmount(invoiceDTO.getAmount());
                invoice.setNotes(invoiceDTO.getNotes());
                invoice.setBillDate(invoiceDTO.getBillDate());
                invoice.setDateDue(invoiceDTO.getBillDate());
                invoice.setProperty(this.propertyRepository.findById(invoiceDTO.getPropertyId()).get());
                invoice.setStat(invoiceDTO.getStat());

                Invoice newInvoice = this.invoiceRepository.save(invoice);

                return responseAPI(newInvoice, "Invoice generated ", HttpStatus.OK);
            }else{
                return responseAPI(null, "No Invoice found", HttpStatus.NOT_FOUND);
            }

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> listInvoices() {
        try{
            List<Invoice> invoices = this.invoiceRepository.findAllByStatNotOrderByIdAsc("deleted");
            if(invoices.isEmpty()){
                return responseAPI(null, "No Invoice found", HttpStatus.NO_CONTENT);
            }else{
                return responseAPI(invoices,"Listing Properties ", HttpStatus.FOUND);
            }

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    public Property isProperty(Long id){
        try{
            Property property =  this.propertyRepository.findById(id).get();

            return property;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public HashMap<String, Object> getPropertyInvoices(Long id) {

        try{
            if( this.isProperty(id) != null){
                Optional<Property> properties = this.propertyRepository.findById(id);
                List<Invoice> propertyInvoice = properties.get().getInvoices();

                if(!propertyInvoice.isEmpty()){
                    return responseAPI(propertyInvoice, "Property Invoices found", HttpStatus.OK);
                }else{
                    return responseAPI(null, "No Invoice found", HttpStatus.NOT_FOUND);
                }

            }else{
                return responseAPI(null, "No Property found", HttpStatus.NOT_FOUND);
            }



        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> getInvoice(Long id) {
        try{

            if(isInvoice(id) != null ){
                Optional<Invoice> invoiceFound = this.invoiceRepository.findById(id);
                return responseAPI(invoiceFound, "Invoice Found ", HttpStatus.OK);
            }else{
                return responseAPI(null, "Invoice not found", HttpStatus.NO_CONTENT);
            }

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> softDelete(Long id) {
        try{

            if(isInvoice(id) != null){

                this.invoiceRepository.softDelete(id,"deleted");
                return this.listInvoices();

            }else{
                return responseAPI(null, "No Invoice found", HttpStatus.NOT_FOUND);
            }

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }
}
