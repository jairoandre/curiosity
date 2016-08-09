package com.fountainledge.curiosity.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.fountainledge.curiosity.model.MarsWeatherFeed;

public class NASAServiceImplTest {
    
    private NASAService nasaService;
    
    @Before
    public void setUp() {
        nasaService = new NASAServiceImpl();
    }
    
    @Test
    public void testGetMarsWeatherFeed() {
        MarsWeatherFeed result = nasaService.getMarsWeatherFeed();
        assertNotNull("Should return a deserialised weather feed", result);
    }
    
}
