package com.codeinsyt.tigerseal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="app_invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="property_id", nullable = false)
    @JsonIgnore
    private Property property;

    private String invoiceId;


    @OneToOne(mappedBy = "invoice", cascade = CascadeType.ALL)
    private Transaction transaction;


    private double amount;

    private String stat;

    private Date dateDue;

    private Date billDate;

    private String propertyNo;

    @Lob
    private String notes;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;

    @CreationTimestamp
    private Date updatedAt;


    public Invoice() {
    }

    public String getPropertyNo() {
        return property.getPropNo();
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", property=" + property +
                ", invoiceId='" + invoiceId + '\'' +
                ", amount=" + amount +
                ", stat='" + stat + '\'' +
                ", dateDue=" + dateDue +
                ", billDate=" + billDate +
                ", notes='" + notes + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
