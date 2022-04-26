package com.example.bank_system;

public class AccountStats14 {
    private String bank;
    private String accountID;
    private Long acountBalance;
    private Integer numOwners;

    public AccountStats14() {

    }

    public AccountStats14(String bank, String accountID, Long acountBalance, Integer numOwners) {
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

    public Long getAcountBalance() {
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

    public void setAcountBalance(Long acountBalance) {
        this.acountBalance = acountBalance;
    }

    public void setNumOwners(Integer numOwners) {
        this.numOwners = numOwners;
    }
}
