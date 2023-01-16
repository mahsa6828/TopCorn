package com.example.tpcorn.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseModelGetMovies {
    @SerializedName("queryString")
    @Expose
    private String queryString;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("errorMessage")
    @Expose
    private Object errorMessage;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

}

