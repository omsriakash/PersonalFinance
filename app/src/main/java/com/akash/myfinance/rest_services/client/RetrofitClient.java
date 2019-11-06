package com.akash.myfinance.rest_services.client;

import android.util.Log;

import com.akash.myfinance.listener.SearchApiCallBack;
import com.akash.myfinance.listener.StockDetailsAPICallBack;
import com.akash.myfinance.rest_services.api.ApiCall;
import com.akash.myfinance.rest_services.model.search.SearchResponse;
import com.akash.myfinance.rest_services.model.stock_details.StockDetailsResponse;
import com.akash.myfinance.utility.FinanceConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final RetrofitClient INSTANCE = new RetrofitClient();

    private ApiCall apiCall;

    public static RetrofitClient getInstance(){ return INSTANCE;}

    public RetrofitClient() {
        Gson gson = new GsonBuilder().setLenient().create();

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        Interceptor headerAuthorizationInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Headers headers = request.headers().newBuilder().build();
                request = request.newBuilder().headers(headers).build();
                return chain.proceed(request);
            }
        };

        clientBuilder.addInterceptor(headerAuthorizationInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FinanceConstants.BASE_URL)
                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        apiCall = retrofit.create(ApiCall.class);
    }

    public void getSearchResults(String function, String name, String apiKey, final SearchApiCallBack searchApiCallBack){

        Call<SearchResponse> searchResponseCall = apiCall.getSearchResults(function,name,apiKey);

        searchResponseCall.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, retrofit2.Response<SearchResponse> response) {
                if (response != null && response.body() != null) {
                    searchApiCallBack.onResponseSucess(response.body());
                }else {
                    searchApiCallBack.onResponseFailure("The requested search is not Available");
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Log.d("12345","failure "+t.getMessage());
                searchApiCallBack.onResponseFailure(t.getMessage());
            }
        });

    }

    public void getStockDetails(String function, String name, String apiKey, final StockDetailsAPICallBack stockDetailsAPICallBack){

        Call<StockDetailsResponse> stockDetailsResponseCall = apiCall.getStockDetails(function,name,apiKey);

        stockDetailsResponseCall.enqueue(new Callback<StockDetailsResponse>() {
            @Override
            public void onResponse(Call<StockDetailsResponse> call, retrofit2.Response<StockDetailsResponse> response) {
                if (response != null && response.body() != null ) {
                    stockDetailsAPICallBack.onResponseSucess(response.body());
                }else {
                    stockDetailsAPICallBack.onResponseFailure("The requested search is not Available");
                }
            }

            @Override
            public void onFailure(Call<StockDetailsResponse> call, Throwable t) {
                stockDetailsAPICallBack.onResponseFailure(t.getMessage());
            }
        });
    }
}
