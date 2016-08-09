package com.fountainledge.curiosity.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fountainledge.curiosity.model.MarsWeatherFeed;

@Service
public class NASAServiceImpl implements NASAService {

    public MarsWeatherFeed getMarsWeatherFeed() {
        MarsWeatherFeed weatherFeed = null;
        RestTemplate restTemplate  = new RestTemplate();
        try {
             weatherFeed = restTemplate.getForObject(new URI("http://marsweather.ingenology.com/v1/archive/"), MarsWeatherFeed.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return weatherFeed;
    }

}
