package com.fountainledge.curiosity.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherReport {
    
    private Timestamp terrestrial_date;
    
    private Double min_temp;
    
    private Double max_temp;
    
    private Double pressure;
    
    private String pressure_string;
    
    private Double wind_speed;
    
    private String atmo_opacity;
    
    private Timestamp sunrise;
    
    private Timestamp sunset;
    
    final static String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public Timestamp getTerrestrial_date() {
        return terrestrial_date;
    }
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT, timezone = "UTC")
    public Timestamp getEarthTime() {
        return terrestrial_date;
    }

    public void setTerrestrial_date(Timestamp terrestrial_date) {
        this.terrestrial_date = terrestrial_date;
    }

    public Double getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(Double min_temp) {
        this.min_temp = min_temp;
    }

    public Double getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(Double max_temp) {
        this.max_temp = max_temp;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public String getPressure_string() {
        return pressure_string;
    }

    public void setPressure_string(String pressure_string) {
        this.pressure_string = pressure_string;
    }

    public Double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getAtmo_opacity() {
        return atmo_opacity;
    }

    public void setAtmo_opacity(String atmo_opacity) {
        this.atmo_opacity = atmo_opacity;
    }

    public Timestamp getSunrise() {
        return sunrise;
    }

    public void setSunrise(Timestamp sunrise) {
        this.sunrise = sunrise;
    }

    public Timestamp getSunset() {
        return sunset;
    }

    public void setSunset(Timestamp sunset) {
        this.sunset = sunset;
    }

}



