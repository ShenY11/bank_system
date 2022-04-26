package com.example.bank_system;

public class EmployeeStats18 {
    private String perID;
    private String taxID;
    private String name;
    private String DOB;
    private String dateJoined;
    private String street;
    private String city;
    private String state;
    private String zip;
    private Integer numBanks;
    private Long bankAssets;

    public EmployeeStats18() {

    }

    public EmployeeStats18(String perID, String taxID, String name, String DOB, String dateJoined,
                           String street, String city, String state, String zip, Integer numBanks,
                           Long bankAssets) {
        setPerID(perID);
        setTaxID(taxID);
        setName(name);
        setDOB(DOB);
        setDateJoined(dateJoined);
        setStreet(street);
        setCity(city);
        setState(state);
        setZip(zip);
        setNumBanks(numBanks);
        setBankAssets(bankAssets);
    }

    public String getPerID() {
        return perID;
    }

    public String getTaxID() {
        return taxID;
    }

    public String getName() {
        return name;
    }

    public String getDOB() {
        return DOB;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public Integer getNumBanks() {
        return numBanks;
    }

    public Long getBankAssets() {
        return bankAssets;
    }

    public void setPerID(String perID) {
        this.perID = perID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setNumBanks(Integer numBanks) {
        this.numBanks = numBanks;
    }

    public void setBankAssets(Long bankAssets) {
        this.bankAssets = bankAssets;
    }
}
