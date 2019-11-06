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

    @SerializedName("02. open")
    private String openPrice;

    @SerializedName("03. high")
    private String intradayHighPrice;

    @SerializedName("04. low")
    private String intradayLowPrice;

    @SerializedName("06. volume")
    private String stockVolume;

    @SerializedName("08. previous close")
    private String previousCLosePrice;

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

    public String getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    public String getIntradayHighPrice() {
        return intradayHighPrice;
    }

    public void setIntradayHighPrice(String intradayHighPrice) {
        this.intradayHighPrice = intradayHighPrice;
    }

    public String getIntradayLowPrice() {
        return intradayLowPrice;
    }

    public void setIntradayLowPrice(String intradayLowPrice) {
        this.intradayLowPrice = intradayLowPrice;
    }

    public String getStockVolume() {
        return stockVolume;
    }

    public void setStockVolume(String stockVolume) {
        this.stockVolume = stockVolume;
    }

    public String getPreviousCLosePrice() {
        return previousCLosePrice;
    }

    public void setPreviousCLosePrice(String previousCLosePrice) {
        this.previousCLosePrice = previousCLosePrice;
    }

}
