package com.freshchat.model;

import java.util.Set;

public class NewrelicMetrics {

    private String from;
    private String to;
    private String[] metrics_not_found;
    private String[] metrics_found;
    private Set<NewrelicMetricsData> metrics;

    public Set<NewrelicMetricsData> getMetrics() {
        return metrics;
    }

    public void setMetrics(Set<NewrelicMetricsData> metrics) {
        this.metrics = metrics;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String[] getMetrics_not_found() {
        return metrics_not_found;
    }

    public void setMetrics_not_found(String[] metrics_not_found) {
        this.metrics_not_found = metrics_not_found;
    }

    public String[] getMetrics_found() {
        return metrics_found;
    }

    public void setMetrics_found(String[] metrics_found) {
        this.metrics_found = metrics_found;
    }
}
