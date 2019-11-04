package com.akash.myfinance.rest_services.model.search;

import com.akash.myfinance.rest_services.model.search.BestMatchesResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {

    @SerializedName("bestMatches")
    private List<BestMatchesResponse> bestMatchesResponse;

    public List<BestMatchesResponse> getBestMatchesResponse() {
        return bestMatchesResponse;
    }

    public void setBestMatchesResponse(List<BestMatchesResponse> bestMatchesResponse) {
        this.bestMatchesResponse = bestMatchesResponse;
    }
}
