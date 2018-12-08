package com.fountainledge.curiosity.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fountainledge.curiosity.model.MarsReport;
import com.fountainledge.curiosity.model.MarsWeatherFeed;
import com.fountainledge.curiosity.model.WeatherReport;

@Service
public class CuriosityServiceImpl implements CuriosityService {
    
    @Autowired
    protected NASAService nasaService;

    Logger logger = LoggerFactory.getLogger(CuriosityServiceImpl.class);
    
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

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private Timestamp toTimeStamp(String dateString) {
        try {
            Date parsedDate = sdf.parse(dateString);
            return new Timestamp(parsedDate.getTime());
        } catch (Exception e) {
            logger.info("Could not parse the date.");
        }
        return null;
    }

    public WeatherReport getByTerrestrialDate(String date) {
        List<WeatherReport> marsWeatherFeed = getLatestWeatherReports();
        Timestamp timestamp = toTimeStamp(date);
        for (WeatherReport report : marsWeatherFeed) {
            if (report.getEarthTime().equals(timestamp))
                return report;
        }
        return null;
    }
        
}
