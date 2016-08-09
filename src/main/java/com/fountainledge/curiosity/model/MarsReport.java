package com.fountainledge.curiosity.model;

import javax.annotation.Resource;

@Resource
public class MarsReport {
    
    private WeatherReport weatherReport;
    
    public WeatherReport getWeatherReport() {
        return weatherReport;
    }

    public void setWeatherReport(WeatherReport weatherReport) {
        this.weatherReport = weatherReport;
    }

}
