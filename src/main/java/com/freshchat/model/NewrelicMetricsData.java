package com.freshchat.model;

import java.util.Set;

public class NewrelicMetricsData {

    private String name;

    private Set<NewrelicTimeslices> timeslices;

    private String[] values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    public Set<NewrelicTimeslices> getTimeslices() {
        return timeslices;
    }

    public void setTimeslices(Set<NewrelicTimeslices> timeslices) {
        this.timeslices = timeslices;
    }
}
