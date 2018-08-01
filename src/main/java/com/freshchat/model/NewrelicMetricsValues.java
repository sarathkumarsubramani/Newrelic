package com.freshchat.model;


import org.codehaus.jackson.annotate.JsonProperty;

public class NewrelicMetricsValues {

    @JsonProperty(value="average_response_time")
    private String averageResponseTime;

    @JsonProperty(value="calls_per_minute")
    private String callsPerMinute;

    @JsonProperty(value="call_count")
    private String callCount;

    @JsonProperty(value="min_response_time")
    private String minResponseTime;

    @JsonProperty(value="max_response_time")
    private String maxResponseTime;

    @JsonProperty(value="average_exclusive_time")
    private String averageExclusiveTime;

    @JsonProperty(value="average_value")
    private String averageValue;

    @JsonProperty(value="total_call_time_per_minute")
    private String totalCallTimePerMinute;

    @JsonProperty(value="requests_per_minute")
    private String requestsPerMinute;

    @JsonProperty(value="standard_deviation")
    private String standardDeviation;

    public String getAverageResponseTime() {
        return averageResponseTime;
    }

    public void setAverageResponseTime(String averageResponseTime) {
        this.averageResponseTime = averageResponseTime;
    }

    public String getCallsPerMinute() {
        return callsPerMinute;
    }

    public void setCallsPerMinute(String callsPerMinute) {
        this.callsPerMinute = callsPerMinute;
    }

    public String getCallCount() {
        return callCount;
    }

    public void setCallCount(String callCount) {
        this.callCount = callCount;
    }

    public String getMinResponseTime() {
        return minResponseTime;
    }

    public void setMinResponseTime(String minResponseTime) {
        this.minResponseTime = minResponseTime;
    }

    public String getMaxResponseTime() {
        return maxResponseTime;
    }

    public void setMaxResponseTime(String maxResponseTime) {
        this.maxResponseTime = maxResponseTime;
    }

    public String getAverageExclusiveTime() {
        return averageExclusiveTime;
    }

    public void setAverageExclusiveTime(String averageExclusiveTime) {
        this.averageExclusiveTime = averageExclusiveTime;
    }

    public String getAverageValue() {
        return averageValue;
    }

    public void setAverageValue(String averageValue) {
        this.averageValue = averageValue;
    }

    public String getTotalCallTimePerMinute() {
        return totalCallTimePerMinute;
    }

    public void setTotalCallTimePerMinute(String totalCallTimePerMinute) {
        this.totalCallTimePerMinute = totalCallTimePerMinute;
    }

    public String getRequestsPerMinute() {
        return requestsPerMinute;
    }

    public void setRequestsPerMinute(String requestsPerMinute) {
        this.requestsPerMinute = requestsPerMinute;
    }

    public String getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(String standardDeviation) {
        this.standardDeviation = standardDeviation;
    }


}
