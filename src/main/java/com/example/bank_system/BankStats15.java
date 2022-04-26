package com.example.bank_system;

public class BankStats15 {
    private String bankID;
    private String corporationName;
    private String bankName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private Integer numAccounts;
    private Long bankAssets;
    private Long totalAssets;

    public BankStats15() {

    }

    public BankStats15(String bankID, String corporationName, String bankName,
                       String street, String city, String state, String zip,
                       Integer numAccounts,Long bankAssets, Long totalAssets) {
        setBankID(bankID);
        setCorporationName(corporationName);
        setBankName(bankName);
        setStreet(street);
        setCity(city);
        setState(state);
        setZip(zip);
        setNumAccounts(numAccounts);
        setBankAssets(bankAssets);
        setTotalAssets(totalAssets);
    }

    public String getBankID() {
        return bankID;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public String getBankName() {
        return bankName;
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

    public Integer getNumAccounts() {
        return numAccounts;
    }

    public Long getBankAssets() {
        return bankAssets;
    }

    public Long getTotalAssets() {
        return totalAssets;
    }

    public void setBankID(String bankID) {
        this.bankID = bankID;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
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

    public void setNumAccounts(Integer numAccounts) {
        this.numAccounts = numAccounts;
    }

    public void setBankAssets(Long bankAssets) {
        this.bankAssets = bankAssets;
    }

    public void setTotalAssets(Long totalAssets) {
        this.totalAssets = totalAssets;
    }
}
