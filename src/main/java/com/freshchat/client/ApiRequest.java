package com.freshchat.client;

import java.util.*;

public class ApiRequest {
    private String endpoint;
    private Map<String, Object> queryParams = new HashMap();
    private List<String> queryStringSet= new ArrayList<String>();


    private ApiRequest(ApiRequest.Builder builder) {
        setEndpoint(builder.endpoint);
        setQueryParams(builder.queryParams);
        setQueryStringSet(builder.queryStringSet);
    }

    public String getEndpoint() { return endpoint; }

    public void setEndpoint(String endpoint) { this.endpoint = endpoint; }

    public Map<String, Object> getQueryParams() { return queryParams; }

    public void setQueryParams(Map<String, Object> queryParams) { this.queryParams = queryParams; }

    public List<String> getQueryStringSet() {
        return queryStringSet;
    }

    public void setQueryStringSet(List<String> queryStringSet) {
        this.queryStringSet = queryStringSet;
    }

    public static final class Builder {
        private String endpoint;
        private Map<String, Object> queryParams = new HashMap();
        private List<String> queryStringSet= new ArrayList<String>();

        public Builder() {}

        public ApiRequest.Builder endpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        public ApiRequest.Builder queryParams(Map<String, Object> queryParams) {
            this.queryParams = queryParams;
            return this;
        }

        public ApiRequest.Builder queryStringSet(List<String> queryStringSet) {
            this.queryStringSet = queryStringSet;
            return this;
        }


        public ApiRequest build() {return new ApiRequest(this);}
    }
}
