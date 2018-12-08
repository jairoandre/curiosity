package com.fountainledge.curiosity.service;

import java.util.List;

import com.fountainledge.curiosity.model.MarsReport;
import com.fountainledge.curiosity.model.WeatherReport;

public interface CuriosityService {
    
    MarsReport getLatestMarsReport();
    
    List<WeatherReport> getLatestWeatherReports();

    WeatherReport getByTerrestrialDate(String date);
    
}
