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
             
             // Use this static file if the API is down
//             InputStream inJson = MarsWeatherFeed.class.getResourceAsStream("/marsweather.json");
//             try {
//                 weatherFeed = new ObjectMapper().readValue(inJson, MarsWeatherFeed.class);
//             } catch (JsonParseException e) {
//                 e.printStackTrace();
//             } catch (JsonMappingException e) {
//                 e.printStackTrace();
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }             
             
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return weatherFeed;
    }

}
