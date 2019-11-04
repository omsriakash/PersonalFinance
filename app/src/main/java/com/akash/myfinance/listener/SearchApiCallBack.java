package com.akash.myfinance.listener;

import com.akash.myfinance.rest_services.model.search.SearchResponse;

public interface SearchApiCallBack {

    void onResponseSucess(SearchResponse responseSuccess);

    void onResponseFailure(String failureResponse);

}
