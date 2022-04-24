package com.example.bank_system;

public class AccountStats14 {
    private String bank;
    private String accountID;
    private Integer acountBalance;
    private Integer numOwners;

    public AccountStats14() {

    }

    public AccountStats14(String bank, String accountID, Integer acountBalance, Integer numOwners) {
        setBank(bank);
        setAccountID(accountID);
        setAcountBalance(acountBalance);
        setNumOwners(numOwners);
    }

    public String getBank() {
        return bank;
    }

    public String getAccountID() {
        return accountID;
    }

    public Integer getAcountBalance() {
        return acountBalance;
    }

    public Integer getNumOwners() {
        return numOwners;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public void setAcountBalance(Integer acountBalance) {
        this.acountBalance = acountBalance;
    }

    public void setNumOwners(Integer numOwners) {
        this.numOwners = numOwners;
    }
}
