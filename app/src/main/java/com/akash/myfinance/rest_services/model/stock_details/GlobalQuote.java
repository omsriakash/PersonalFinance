package com.akash.myfinance.rest_services.model.stock_details;

import com.google.gson.annotations.SerializedName;

public class GlobalQuote {

    @SerializedName("01. symbol")
    private String symbol;

    @SerializedName("05. price")
    private String price;

    @SerializedName("09. change")
    private Double changeNumber;

    @SerializedName("10. change percent")
    private String changePercentageNumber;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Double getChangeNumber() {
        return changeNumber;
    }

    public void setChangeNumber(Double changeNumber) {
        this.changeNumber = changeNumber;
    }

    public String getChangePercentageNumber() {
        return changePercentageNumber;
    }

    public void setChangePercentageNumber(String changePercentageNumber) {
        this.changePercentageNumber = changePercentageNumber;
    }
}
