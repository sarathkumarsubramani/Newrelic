package com.freshchat.model;

public class NewrelicReport implements Comparable{

    private String name;

    private String averageResponseTime;

    private String callsPerMinute;

    private String callCount;

    private String minResponseTime;

    private String maxResponseTime;

    private String averageExclusiveTime;

    private String averageValue;

    private String totalCallTimePerMinute;

    private String requestsPerMinute;

    private String standardDeviation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    @Override
    public int compareTo(Object o) {

        if(o instanceof NewrelicReport)
        {
            float currentaverageResponseTime = Float.parseFloat(this.averageResponseTime);
            float objectaverageResponseTime = Float.parseFloat(((NewrelicReport) o).averageResponseTime);

            if(currentaverageResponseTime == objectaverageResponseTime){return 0;}
            if(currentaverageResponseTime < objectaverageResponseTime){return 1;}
            if(currentaverageResponseTime > objectaverageResponseTime){return -1;}
        }
        return 0;
    }
}
