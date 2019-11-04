package com.akash.myfinance.rest_services.api;

import com.akash.myfinance.rest_services.model.search.SearchResponse;
import com.akash.myfinance.rest_services.model.stock_details.StockDetailsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCall {

    @GET("/query?")
    Call<SearchResponse> getSearchResults(@Query("function") String function,
                                          @Query("keywords") String name, @Query("apikey") String apiKey);

    @GET("/query?")
    Call<StockDetailsResponse> getStockDetails(@Query("function") String function,
                                               @Query("symbol") String name, @Query("apikey") String apiKey);

}
