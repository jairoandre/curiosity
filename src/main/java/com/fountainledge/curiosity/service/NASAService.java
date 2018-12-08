package com.fountainledge.curiosity.service;

import com.fountainledge.curiosity.model.MarsWeatherFeed;
import com.fountainledge.curiosity.model.NasaPictureObject;

import java.util.List;

public interface NASAService {
    
    MarsWeatherFeed getMarsWeatherFeed();

    List<NasaPictureObject> getMarsPictures(String earthDate);
    
}
