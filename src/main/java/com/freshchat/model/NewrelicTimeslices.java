package com.freshchat.model;

public class NewrelicTimeslices {

    private String from;
    private String to;
    private NewrelicMetricsValues values;

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

    public NewrelicMetricsValues getValues() {
        return values;
    }

    public void setValues(NewrelicMetricsValues values) {
        this.values = values;
    }
}
