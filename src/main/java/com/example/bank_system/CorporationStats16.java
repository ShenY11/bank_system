package com.example.bank_system;

public class CorporationStats16 {
    private String corporationID;
    private String shortName;
    private String formalName;
    private Integer numBanks;
    private Long corporationAssets;
    private Long totalAssets;

    public CorporationStats16() {

    }

    public CorporationStats16(String corporationID, String shortName, String formalName,
                                   Integer numBanks, Long corporationAssets, Long totalAssets) {
        setCorporationID(corporationID);
        setShortName(shortName);
        setFormalName(formalName);
        setNumBanks(numBanks);
        setCorporationAssets(corporationAssets);
        setTotalAssets(totalAssets);
    }

    public String getCorporationID() {
        return corporationID;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFormalName() {
        return formalName;
    }

    public Integer getNumBanks() {
        return numBanks;
    }

    public Long getCorporationAssets() {
        return corporationAssets;
    }

    public Long getTotalAssets() {
        return totalAssets;
    }

    public void setCorporationID(String corporationID) {
        this.corporationID = corporationID;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setFormalName(String formalName) {
        this.formalName = formalName;
    }

    public void setNumBanks(Integer numBanks) {
        this.numBanks = numBanks;
    }

    public void setCorporationAssets(Long corporationAssets) {
        this.corporationAssets = corporationAssets;
    }

    public void setTotalAssets(Long totalAssets) {
        this.totalAssets = totalAssets;
    }
}
