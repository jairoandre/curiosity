package com.fountainledge.curiosity.client;

import com.fountainledge.curiosity.model.NasaPictureFeed;
import feign.Param;
import feign.RequestLine;

public interface NasaPictureClient {

  @RequestLine("GET /photos?earth_date={earth_date}&api_key={api_key}")
  NasaPictureFeed getPictures(@Param("earth_date") String earthDate, @Param("api_key") String apiKey);

}
