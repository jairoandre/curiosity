package com.fountainledge.curiosity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fountainledge.curiosity.model.MarsReport;
import com.fountainledge.curiosity.model.MarsWeatherFeed;
import com.fountainledge.curiosity.model.WeatherReport;

@Service
public class CuriosityServiceImpl implements CuriosityService {
    
    @Autowired
    protected NASAService nasaService;
    
    public MarsReport getLatestMarsReport() {
        
        MarsReport marsReport = new MarsReport();
        List<WeatherReport> latestWeatherReports = this.getLatestWeatherReports();
        if (latestWeatherReports.size() > 0) {
            marsReport.setWeatherReport(latestWeatherReports.get(0));
        }
        
        return marsReport;
    }

    public List<WeatherReport> getLatestWeatherReports() {
        MarsWeatherFeed marsWeatherFeed = nasaService.getMarsWeatherFeed();
        return marsWeatherFeed.getResults();
    }
        
}
