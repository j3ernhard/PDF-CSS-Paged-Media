package me.jungwirth.playground.springboot.pdf.pagedmedia.model.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ELadestelle {

    @JsonProperty("OBJECTID")
    private Long objectId;

    @JsonProperty("ADDRESS")
    private String address;

    @JsonProperty("BEZIRK")
    private Long bezirk;

    @JsonProperty("CITY")
    private String city;

    @JsonProperty("COUNTRYCODE")
    private String countryCode;

    @JsonProperty("DESIGNATION")
    private String designation;

    @JsonProperty("EVSEID")
    private String evseId;

    @JsonProperty("OPERATORNAME")
    private String operatorName;

    @JsonProperty("SOURCE")
    private String source;

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getBezirk() {
        return bezirk;
    }

    public void setBezirk(Long bezirk) {
        this.bezirk = bezirk;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEvseId() {
        return evseId;
    }

    public void setEvseId(String evseId) {
        this.evseId = evseId;
    }

    public String getOperatorName() {
        return operatorName;
    }
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    @Override
    public String toString() {
        return "[objectid="+getObjectId()+", address="+getAddress()+", bezirk="+getBezirk()+"]";
    }

    
}
