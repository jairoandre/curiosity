package com.fountainledge.curiosity.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarsWeatherFeed {

    private List<WeatherReport> results;

    public List<WeatherReport> getResults() {
        return results;
    }

    public void setResults(List<WeatherReport> results) {
        this.results = results;
    }
    
}
