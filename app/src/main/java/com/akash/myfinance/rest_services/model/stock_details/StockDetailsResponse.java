package com.akash.myfinance.rest_services.model.stock_details;

import com.google.gson.annotations.SerializedName;

public class StockDetailsResponse {

    @SerializedName("Global Quote")
    private GlobalQuote globalQuote;

    public GlobalQuote getGlobalQuote() {
        return globalQuote;
    }

    public void setGlobalQuote(GlobalQuote globalQuote) {
        this.globalQuote = globalQuote;
    }
}
