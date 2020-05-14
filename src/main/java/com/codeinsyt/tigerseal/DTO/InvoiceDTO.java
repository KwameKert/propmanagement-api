package com.codeinsyt.tigerseal.DTO;

import com.codeinsyt.tigerseal.models.Property;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

public class InvoiceDTO {


    private Long invoiceId;

    private Long propertyId;

    private int price;

    private String stat;


    @Lob
    private String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
