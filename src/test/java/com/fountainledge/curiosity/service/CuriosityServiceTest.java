package com.fountainledge.curiosity.service;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CuriosityServiceTest {
    
    private CuriosityServiceImpl curiosityService;
    
    @Mock
    private NASAService nasaService;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        curiosityService = new CuriosityServiceImpl();
        curiosityService.nasaService = nasaService;
    }
    
    
}
