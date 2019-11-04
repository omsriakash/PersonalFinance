package com.akash.myfinance.listener;

import com.akash.myfinance.rest_services.model.stock_details.StockDetailsResponse;

public interface StockDetailsAPICallBack {

    void onResponseSucess(StockDetailsResponse responseSuccess);

    void onResponseFailure(String failureResponse);

}
