package com.akash.myfinance.rest_services.model.search;

import com.google.gson.annotations.SerializedName;

public class BestMatchesResponse {

    @SerializedName("1. symbol")
    private String symbol;

    @SerializedName("2. name")
    private String companyName;

    @SerializedName("3. type")
    private String stockType;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

}
