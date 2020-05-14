package com.codeinsyt.tigerseal.DTO;

import com.codeinsyt.tigerseal.models.Property;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.util.Date;

public class InvoiceDTO {



    private Long id;

    private String invoiceId;

    private Long propertyId;


    private double amount;

    private String stat = "Unpaid";

    private Date dateDue;

    private Date billDate;

    @Lob
    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public Date getDateDue() {
        return dateDue;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    @Override
    public String toString() {
        return "InvoiceDTO{" +
                "id=" + id +
                ", invoiceId='" + invoiceId + '\'' +
                ", propertyId=" + propertyId +
                ", amount=" + amount +
                ", stat='" + stat + '\'' +
                ", dateDue=" + dateDue +
                ", billDate=" + billDate +
                ", notes='" + notes + '\'' +
                '}';
    }
}
