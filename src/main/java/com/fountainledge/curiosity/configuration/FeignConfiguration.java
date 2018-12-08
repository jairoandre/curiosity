package com.fountainledge.curiosity.configuration;

import com.fountainledge.curiosity.client.NasaPictureClient;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

  public static final String apiUrl = "https://jsonplaceholder.typicode.com/users";

  @Value("${nasa.api.url}")
  private String nasaApiUrl;

  @Bean
  public NasaPictureClient getNasaPictureClient() {
    return new Feign.Builder()
        .client(new OkHttpClient())
        .encoder(new GsonEncoder())
        .decoder(new GsonDecoder())
        .logLevel(Logger.Level.FULL)
        .logger(new Slf4jLogger(NasaPictureClient.class))
        .target(NasaPictureClient.class, nasaApiUrl);
  }
}
