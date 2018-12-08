package com.fountainledge.curiosity.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fountainledge.curiosity.client.NasaPictureClient;
import com.fountainledge.curiosity.model.MarsWeatherFeed;
import com.fountainledge.curiosity.model.NasaPictureFeed;
import com.fountainledge.curiosity.model.NasaPictureObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.TimeZone;

@Service
public class NASAServiceImpl implements NASAService {

  @Value("${nasa.api.key}")
  private String apiKey;

  @Autowired
  private NasaPictureClient nasaPictureClient;

  public MarsWeatherFeed getMarsWeatherFeed() {
    MarsWeatherFeed weatherFeed = null;
    RestTemplate restTemplate = new RestTemplate();
    try {
      //weatherFeed = restTemplate.getForObject(new URI("http://marsweather.ingenology.com/v1/archive/"), MarsWeatherFeed.class);

      // Use this static file if the API is down
      InputStream inJson = MarsWeatherFeed.class.getResourceAsStream("/marsweather.json");
      try {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setTimeZone(TimeZone.getDefault());
        weatherFeed = mapper.readValue(inJson, MarsWeatherFeed.class);
      } catch (JsonParseException e) {
        e.printStackTrace();
      } catch (JsonMappingException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (RestClientException e) {
      e.printStackTrace();
    }
    return weatherFeed;
  }

  public List<NasaPictureObject> getMarsPictures(String earthDate) {
    NasaPictureFeed feed = nasaPictureClient.getPictures(earthDate, apiKey);
    if (feed == null)
      return null;
    return feed.getPhotos();
  }

}
