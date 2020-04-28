package com.codeinsyt.tigerseal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="app_property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String propNo;

    private String propCat;

    private String electoralArea;

    private Float rate;

    private Long latitude;

    private Long longitude;

    private int value;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="property_owner_id", nullable= false)
    @JsonIgnore
    private PropertyOwner propertyOwner;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;

    @CreationTimestamp
    @Column(updatable = false)
    private Date updatedAt;


    public Property() {
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

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
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


    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", propNo='" + propNo + '\'' +
                ", propCat='" + propCat + '\'' +
                ", electoralArea='" + electoralArea + '\'' +
                ", rate=" + rate +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }


    public PropertyOwner getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(PropertyOwner propertyOwner) {
        this.propertyOwner = propertyOwner;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
