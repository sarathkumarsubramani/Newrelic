package com.freshchat.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class NewrelicMetadata {

    @JsonProperty(value = "metric_data")
    private NewrelicMetrics metricData;

    public NewrelicMetrics getMetricData() {
        return metricData;
    }

    public void setMetricData(NewrelicMetrics metricData) {
        this.metricData = metricData;
    }
}
