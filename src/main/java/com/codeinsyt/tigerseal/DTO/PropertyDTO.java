package com.codeinsyt.tigerseal.DTO;

public class PropertyDTO {

    private String propNo;

    private String propCat;

    private String electoralArea;

    private Float rate;

    private String stat;

    private Double latitude;

    private Double longitude;

    private int value;

    private Long owner_id;

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

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }
}
