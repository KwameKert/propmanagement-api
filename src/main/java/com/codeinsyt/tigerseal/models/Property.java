package com.codeinsyt.tigerseal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name="app_properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String owner;

    private String propNo;

    private String propCat;

    private String electoralArea;

    private Float rate;

    private String stat;

    private Double latitude;

    private Double longitude;

    private int value;

    private Long ownerId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable= true)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Property> invoices;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;

    @CreationTimestamp
    @Column(updatable = false)
    private Date updatedAt;


    public Property() {
    }

    public Long getOwnerId() {
        return user.getId();
    }

    public String getOwner() {
        return this.user.getUsername();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropNo() {
        return propNo;
    }

    public void setPropNo(String propNo) {
        this.propNo = propNo;
    }

    public String getPropCat() {
        return propCat;
    }

    public void setPropCat(String propCat) {
        this.propCat = propCat;
    }

    public String getElectoralArea() {
        return electoralArea;
    }

    public void setElectoralArea(String electoralArea) {
        this.electoralArea = electoralArea;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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


    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<Property> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Property> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", propNo='" + propNo + '\'' +
                ", propCat='" + propCat + '\'' +
                ", electoralArea='" + electoralArea + '\'' +
                ", rate=" + rate +
                ", stat='" + stat + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", value=" + value +
                ", user=" + user +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
